package br.com.paygo.kafka.services.impl;

import br.com.paygo.kafka.services.KafkaService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.util.regex.Pattern;

public class LogService extends KafkaService {

    public LogService() {
        this.aClass = LogService.class;
        this.initString = "Há novos registros para log";
        this.topicsAsAhPattern = Pattern.compile("KAFKA.*");
    }

    @Override
    protected void parse(ConsumerRecord<String, String> record) {
        System.out.println( "(topic     = " + record.topic() + ")\n" +
                            "(offset    = " + record.offset() + ")\n" +
                            "(key       = " + record.key() + ")\n" +
                            "(value     = " + record.value() + ")");
    }

}

