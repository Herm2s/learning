package com.hermes.mqtest;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author liu.zongbin
 * @since 2023/6/13
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("172.23.5.185");
        factory.setPort(5673);

        try (Connection conn = factory.newConnection()) {
        }

    }
}
