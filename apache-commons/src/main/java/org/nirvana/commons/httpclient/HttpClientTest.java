package org.nirvana.commons.httpclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientTest
{
    public static void main(String[] args)
        throws Exception
    {
        HttpClient client = new DefaultHttpClient();
        HttpGet method = new HttpGet("http://sbs-tangseng:28017/enotifydb/asset/");
        HttpResponse response = client.execute(method);
        HttpEntity entity = response.getEntity();
        System.out.println(response.getStatusLine());
        System.out.println("############################ HEAD ##############################");
        for (Header head : response.getAllHeaders())
        {
            System.out.println(head.getName() + " : " + head.getValue());
        }
        System.out.println("############################ BODY ##############################");
        if (entity != null)
        {
            InputStream instream = entity.getContent();
            try
            {
                InputStreamReader inR = new InputStreamReader(instream);
                BufferedReader buf = new BufferedReader(inR);
                String line;
                while ((line = buf.readLine()) != null)
                {
                    System.out.println(line);
                }
            }
            finally
            {
                instream.close();
            }
        }
    }
}
