package br.com.paygo.kafka.services.impl;

import br.com.paygo.kafka.services.KafkaService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.util.Arrays;

public class EmailService extends KafkaService {

    public EmailService() {
        this.aClass = EmailService.class;
        this.initString = "Há novos registros em email";
        this.topicsAsAhList = Arrays.asList("KAFKA_SEND_EMAIL");
    }


    @Override
    protected void parse(ConsumerRecord<String, String> record) {
        System.out.println( "(topic     = " + record.topic() + ")\n" +
                            "(offset    = " + record.offset() + ")\n" +
                            "(key       = " + record.key() + ")\n" +
                            "(value     = " + record.value() + ")");
    }

}
