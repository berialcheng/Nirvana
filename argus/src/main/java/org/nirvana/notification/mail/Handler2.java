package org.nirvana.notification.mail;

import org.apache.camel.Exchange;

public class Handler2
{

    /**
     * @param args
     */
    public void process(Exchange exchange)
    {
        System.out.println(exchange);
    }
}
