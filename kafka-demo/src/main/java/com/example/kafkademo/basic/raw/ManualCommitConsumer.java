package com.example.kafkademo.basic.raw;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ManualCommitConsumer {

    public void consume(){
        //Kafka consumer configuration settings
        String topicName = "raw";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test-non-auto-commit");
        props.put("enable.auto.commit", "false");
        props.put("auto.offset.reset", "earliest");
        props.put("max.poll.records", "5");
        //props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("max.poll.interval.ms", "300000");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer
                <String, String>(props);

        //Kafka Consumer subscribes list of topics here.
        consumer.subscribe(Arrays.asList(topicName));

        //print the topic name
        System.out.println("Subscribed to topic " + topicName);
        int i = 0;

        final int minBatchSize = 1;
        List<ConsumerRecord<String, String>> buffer = new ArrayList<>();

        while (true) {
            //ConsumerRecords<String, String> records = consumer.poll(100);
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                // print the offset,key and value for the consumer records.
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
                buffer.add(record);
            }

//            if (buffer.size() >= minBatchSize) {
//                consumer.commitSync();
//                buffer.clear();
//            }

            if (buffer.size() >= minBatchSize) {
                continue;
                //buffer.clear();
            }
        }
    }

    public static void main(String[] args) {
        new ManualCommitConsumer().consume();
    }
}
