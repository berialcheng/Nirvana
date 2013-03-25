package org.nirvana.commons.httpclient;

import java.net.URI;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

public class HttpRequestTest
{

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args)
        throws Exception
    {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http").setHost("www.google.com").setPath("/search").setParameter("q", "httpclient")
                .setParameter("btnG", "Google Search").setParameter("aq", "f").setParameter("oq", "");
        URI uri = builder.build();
        HttpGet httpget = new HttpGet(uri);
        System.out.println(httpget.getURI());
    }

}
