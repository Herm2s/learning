package com.hermes.netty.protocol;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * 序列化和反序列化接口
 *
 * @author liu.zongbin
 * @since 2022/7/16 19:29
 */
public interface Serializer {

    /**
     * 反序列化
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);

    /**
     * 序列化
     */
    <T> byte[] serialize(T object);

    /**
     * 序列化算法
     */
    enum Algorithm implements Serializer {

        /**
         * JAVA
         */
        JAVA {
            @Override
            public <T> T deserialize(Class<T> clazz, byte[] bytes) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
                    return (T) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException("反序列化失败", e);
                }
            }

            @Override
            public <T> byte[] serialize(T object) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(object);
                } catch (IOException e) {
                    throw new RuntimeException("序列化失败", e);
                }
                return bos.toByteArray();
            }
        },

        /**
         * JSON
         */
        JSON {
            @Override
            public <T> T deserialize(Class<T> clazz, byte[] bytes) {
                Gson gson = new GsonBuilder().registerTypeAdapter(Class.class, new ClassCodec()).create();
                String jsonStr = new String(bytes, StandardCharsets.UTF_8);
                return gson.fromJson(jsonStr, clazz);
            }

            @Override
            public <T> byte[] serialize(T object) {
                Gson gson = new GsonBuilder().registerTypeAdapter(Class.class, new ClassCodec()).create();
                String json = gson.toJson(object);
                return json.getBytes(StandardCharsets.UTF_8);
            }
        };

        static class ClassCodec implements JsonSerializer<Class<?>>, JsonDeserializer<Class<?>> {

            @Override
            public Class<?> deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                String str = json.getAsString();
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException e) {
                    throw new JsonParseException(e);
                }
            }

            @Override
            public JsonElement serialize(Class<?> src, Type type, JsonSerializationContext jsonSerializationContext) {
                return new JsonPrimitive(src.getName());
            }
        }
    }
}
