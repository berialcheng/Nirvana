package org.nirvana;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(App.class,"/");
        Template temp = cfg.getTemplate("hello.ftl");
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("username", "Adrian");
        temp.process(model, new PrintWriter(System.out));
    }
}
