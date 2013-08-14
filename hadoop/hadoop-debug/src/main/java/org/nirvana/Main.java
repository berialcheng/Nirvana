package org.nirvana;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;


class Main{
	public static void main(String args[]){

	    JobConf conf = new JobConf();
        conf.setJobName("Debug");

        conf.set("fs.file.impl", "com.hp.it.cdc.robin.hadoop.winpatch.WinFileSystem");

        conf.setMapperClass(org.nirvana.mapred.DebugMapper.class);
        conf.setReducerClass(org.nirvana.mapred.DebugReducer.class);
        conf.setNumMapTasks(3);
        
        FileInputFormat.setInputPaths(conf, new Path("C:\\opt\\hadoop-1.0.4\\input"));
        FileOutputFormat.setOutputPath(conf, new Path("C:\\tmp\\output"));

        try
        {
            JobClient.runJob(conf);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
}
