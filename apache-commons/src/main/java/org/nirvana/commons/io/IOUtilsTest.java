package org.nirvana.commons.io;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class IOUtilsTest
{

    /**
     * @param args
     * @throws Exception 
     * @throws MalformedURLException 
     */
    public static void main(String[] args)
        throws MalformedURLException, Exception
    {
        InputStream in = new URL("http://localhost:28017/enotifydb/asset/").openStream();
        try
        {
            System.out.println(IOUtils.toString(in));
        }
        finally
        {
            IOUtils.closeQuietly(in);
        }
    }
}
