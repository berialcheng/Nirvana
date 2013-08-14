package org.nirvana.mapred;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class DebugMapper implements Mapper<LongWritable, Text, LongWritable, Text>
{

    public void configure(JobConf job)
    {
        // TODO Auto-generated method stub
    }

    public void close()
        throws IOException
    {
        // TODO Auto-generated method stub
    }

    public void map(LongWritable key, Text value, OutputCollector<LongWritable, Text> output, Reporter reporter)
        throws IOException
    {
        System.out.println(Thread.currentThread().getName() + " :Mapper: KEY=" + key + "," + value);
        output.collect(key, value);
    }

}
