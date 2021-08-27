package br.com.paygo.kafka.services.impl;

import br.com.paygo.kafka.services.KafkaService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.util.Arrays;

public class FraudDetectorService extends KafkaService {

    public FraudDetectorService() {
        this.aClass = FraudDetectorService.class;
        this.initString = "Há novos registros em detecção de fraude";
        this.topicsAsAhList = Arrays.asList("KAFKA_NEW_ORDER");
    }


    @Override
    protected void parse(ConsumerRecord<String, String> record) {
        System.out.println( "(topic     = " + record.topic() + ")\n" +
                "(offset    = " + record.offset() + ")\n" +
                "(key       = " + record.key() + ")\n" +
                "(value     = " + record.value() + ")");
    }

}
