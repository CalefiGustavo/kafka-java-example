package br.com.paygo.kafka.dispatchers;

import br.com.paygo.kafka.models.Order;
import br.com.paygo.kafka.utils.PropertiesConstants;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class KafkaDispatcher<T> implements Closeable {

    private final KafkaProducer<String, T> producer;

    public KafkaDispatcher() {
        this.producer = new KafkaProducer(PropertiesConstants.getProducerConfigProperties());

    }

    public void send(String topic, String key, T payload, Callback callback) throws ExecutionException, InterruptedException {
        ProducerRecord producerRecord = new ProducerRecord(topic, key, payload);
        this.producer.send(producerRecord, callback).get();
    }

    @Override
    public void close() {
        this.producer.close();
    }

}
