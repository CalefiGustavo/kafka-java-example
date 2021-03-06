package br.com.paygo.kafka.utils.serializer;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class GsonSerializer<T> implements Serializer<T> {


    private final Gson gson = new GsonBuilder().create();

    @Override
    public byte[] serialize(String s, T t) {
        return gson.toJson(t).getBytes();
    }
}
