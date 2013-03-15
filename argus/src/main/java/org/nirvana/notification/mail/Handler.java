package org.nirvana.notification.mail;

import org.apache.camel.Exchange;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class Handler
{

    /**
     * @param args
     */
    public void process(Exchange exchange)
    {
        DBObject object = (DBObject)JSON.parse("{sendTs:null}");
        exchange.getIn().setBody(object);
    }
}
