package br.com.paygo.kafka.utils.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

public class GsonDeserializer<T> implements Deserializer<T> {


    private final Gson gson = new GsonBuilder().create();

    @Override
    public T deserialize(String s, byte[] bytes) {
        return null;
    }
}
