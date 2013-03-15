package org.nirvana.notification.mail;

import java.sql.Timestamp;

import org.apache.camel.Exchange;
import org.apache.camel.converter.stream.InputStreamCache;

public class EmailResolver
{

    /**
     * @param args
     */
    public void process(Exchange exchange)
    {
        Email mail = new Email();
        mail.setTo(exchange.getIn().getHeader("to").toString());
        mail.setSubject(exchange.getIn().getHeader("subject").toString());
        mail.setFrom(exchange.getIn().getHeader("from").toString());
        mail.setBody(streamToString((InputStreamCache)exchange.getIn().getBody()));
        mail.setInsertTs(new Timestamp(System.currentTimeMillis()));
        exchange.getIn().setBody(mail);
    }
    
    public static String streamToString(java.io.InputStream is_)
    {
        try
        {
        if (is_ != null) {
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(is_, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is_.close();
            }
            return sb.toString();
        } else {
            return "";
        }
        }
        catch (Exception ex)
        {
        return null;
        }
    }
}
