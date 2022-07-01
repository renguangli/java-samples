package com.renguangli.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

public class Producer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<>(p);

        String topic = "test-1";
        String content = "test.test";
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, content);
        Future<RecordMetadata> sendFuture = producer.send(record);
        RecordMetadata metadata = sendFuture.get();
        int partition = metadata.partition();
        long offset = metadata.offset();
        System.out.println(partition);
        System.out.println(offset);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(p);
        consumer.subscribe(Pattern.compile("sss"));
        final ConsumerRecords<String, String> poll = consumer.poll(Duration.ZERO);
        final Iterable<ConsumerRecord<String, String>> topic1 = poll.records("topic");
    }
}
