package br.com.paygo.kafka.utils;

import br.com.paygo.kafka.utils.serializer.GsonSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

public class PropertiesConstants {


    private static final String SERVER = "127.0.0.1:9092";

    public static Properties getConsumerConfigProperties(Class<?> aClass) {
        Properties properties = new Properties();
        addConfig(properties, ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER);
        addConfig(properties, ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        addConfig(properties, ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        addConfig(properties, ConsumerConfig.GROUP_ID_CONFIG, aClass.getSimpleName());
        addConfig(properties, ConsumerConfig.CLIENT_ID_CONFIG, UUID.randomUUID().toString());
        addConfig(properties, ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
        return properties;
    }


    public static Properties getProducerConfigProperties() {
        Properties properties = new Properties();
        addConfig(properties, ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVER);
        addConfig(properties, ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        addConfig(properties, ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
        return properties;
    }

    private static void addConfig(Properties properties, String configuration, String value) {
        properties.setProperty(configuration, value);
    }


}
