package org.nirvana.commons.io;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtilsTest
{
    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args)
        throws Exception
    {
        File file = new File(FileUtilsTest.class.getClassLoader().getResource("data.json").toURI());
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        for (String line : lines)
        {
            System.out.println(line);
        }
    }

}
