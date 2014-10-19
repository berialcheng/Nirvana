package org.nirvana;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CustomizedTemplaterLoader 
{
    public static void main( String[] args ) throws Exception
    {
    	Configuration cfg = new Configuration();
    	cfg.setTemplateLoader(new CustomizedLoader());
        Template temp = cfg.getTemplate("whatever");
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("username", "Adrian");
        temp.process(model, new PrintWriter(System.out));
    }
    
    static class CustomizedLoader implements freemarker.cache.TemplateLoader{

		public Object findTemplateSource(String name) throws IOException {
			return this.getClass().getClassLoader().getResource("hello.ftl");
		}

		public long getLastModified(Object templateSource) {
			// TODO Auto-generated method stub
			return 0;
		}

		public Reader getReader(Object templateSource, String encoding)
				throws IOException {
			return new InputStreamReader(((URL)templateSource).openStream());
		}

		public void closeTemplateSource(Object templateSource)
				throws IOException {
			// TODO Auto-generated method stub
		}
    	
    }
}
