package org.nirvana.mapred;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class DebugReducer implements Reducer<LongWritable, Text, LongWritable, Text>
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

    public void reduce(LongWritable key, Iterator<Text> values, OutputCollector<LongWritable, Text> output,
            Reporter reporter)
        throws IOException
    {
        System.out.println(Thread.currentThread().getName() + " :Reducer: key[" + key + "] value[" + values + "]");
        output.collect(key, new Text(values.toString()));
    }

}
