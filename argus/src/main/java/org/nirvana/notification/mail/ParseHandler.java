package org.nirvana.notification.mail;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.camel.Exchange;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class ParseHandler
{
    public void findAll(Exchange exchange)
    {
        DBObject object = (DBObject)JSON.parse("{sendTs:null}");
        exchange.getIn().setBody(object);
    }

    public Collection spliter(ArrayList body, Exchange exchange)
    {
        return body;
    }

    public void convertToMap(Exchange exchange)
    {
        Map<String, Object> map = exchange.getIn().getBody(Map.class);
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
        DBObject filter = new BasicDBObject("_id", new BasicDBObject("_id", exchange.getIn().getHeader("_id")));
        DBObject update = new BasicDBObject("sendTs", new Timestamp(System.currentTimeMillis()));
        exchange.getIn().setBody(new Object[] {filter, update});
    }
}
