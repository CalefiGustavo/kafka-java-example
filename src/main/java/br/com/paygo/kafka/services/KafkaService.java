package br.com.paygo.kafka.services;

import br.com.paygo.kafka.utils.PropertiesConstants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

abstract public class KafkaService {

    protected Class aClass;
    protected String initString;
    protected List<String> topicsAsAhList;
    protected Pattern topicsAsAhPattern;

    public void run() {
        KafkaConsumer consumer = new KafkaConsumer(PropertiesConstants.getConsumerConfigProperties(aClass));
        subscribe(consumer);
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            if (!records.isEmpty()) {
                System.out.println(initString);
                records.forEach(this::parse);
            }
        }
    }

    private void subscribe(KafkaConsumer consumer) {
        if(topicsAsAhList != null) {
            consumer.subscribe(topicsAsAhList);
        } else if (topicsAsAhPattern != null){
            consumer.subscribe(topicsAsAhPattern);
        }
    }

    abstract protected void parse(ConsumerRecord<String, String> record);

}
