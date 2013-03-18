package org.nirvana.notification.mail;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.converter.stream.InputStreamCache;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class EmailResolver
{
    public void insert(Exchange exchange)
    {
        Map<String, Object> mail = new HashMap<String, Object>();
        mail.put("from", exchange.getIn().getHeader("from").toString());
        mail.put("to", exchange.getIn().getHeader("to").toString());
        mail.put("cc", exchange.getIn().getHeader("cc").toString());
        mail.put("subject", exchange.getIn().getHeader("subject").toString());
        mail.put("body", streamToString((InputStreamCache)exchange.getIn().getBody()));
        mail.put("inserTs", new Timestamp(System.currentTimeMillis()));
        exchange.getIn().setBody(mail);
    }

    public void findAll(Exchange exchange, ApplicationContext applicationContext)
    {
        //Parameterized the retry count 
        exchange.getIn()
                .setBody(
                        "{$and: [ {sendTs:null},{$or: [{exception:null},{exception:{$size:0}},{exception:{$size:1}},{exception:{$size:2}}]}]}");
    }

    public Collection spliter(ArrayList body, Exchange exchange)
    {
        return body;
    }

    public void convertToMap(Exchange exchange)
    {
        Map<String, Object> map = exchange.getIn().getBody(Map.class);
        exchange.getIn().setHeader("Content-Type", "text/html");

        for (Map.Entry<String, Object> entry : map.entrySet())
        {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key.equalsIgnoreCase("_id"))
            {
                exchange.getIn().setHeader("_id", value);
            }
            else if (key.equalsIgnoreCase("subject"))
            {
                exchange.getIn().setHeader("subject", value);
            }
            else if (key.equalsIgnoreCase("from"))
            {
                exchange.getIn().setHeader("from", value);
            }
            else if (key.equalsIgnoreCase("to"))
            {
                exchange.getIn().setHeader("to", value);
            }
            else if (key.equalsIgnoreCase("cc"))
            {
                exchange.getIn().setHeader("cc", value);
            }
            else if (key.equalsIgnoreCase("body"))
            {
                exchange.getIn().setBody(value);
            }
        }
    }

    public void update(Exchange exchange)
    {
        DBObject filter = new BasicDBObject("_id", new ObjectId(exchange.getIn().getHeader("_id").toString()));
        DBObject update = new BasicDBObject("$set", new BasicDBObject().append("sendTs",
                new Timestamp(System.currentTimeMillis())));
        exchange.getIn().setBody(new Object[] {filter, update});
    }

    public void error(Exchange exchange, Exception exception)
    {
        DBObject filter = new BasicDBObject("_id", new ObjectId(exchange.getIn().getHeader("_id").toString()));
        DBObject addExceptionTrace = new BasicDBObject("$push", new BasicDBObject().append("exception",
                exception.getMessage()));
        exchange.getIn().setBody(new Object[] {filter, addExceptionTrace});
    }

    public static String streamToString(java.io.InputStream is_)
    {
        try
        {
            if (is_ != null)
            {
                StringBuilder sb = new StringBuilder();
                String line;
                try
                {
                    java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(is_,
                            "UTF-8"));
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line).append("\n");
                    }
                }
                finally
                {
                    is_.close();
                }
                return sb.toString();
            }
            else
            {
                return "";
            }
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
