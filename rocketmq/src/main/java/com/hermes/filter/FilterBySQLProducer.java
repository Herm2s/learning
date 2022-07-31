package com.hermes.filter;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @author liu.zongbin
 * @created 2022/7/31 19:36
 */
public class FilterBySQLProducer {

    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("rocketmqOS:9876");
        producer.start();

        for (int i = 0; i < 10; i++) {
            byte[] body = ("Hi, " + i).getBytes(StandardCharsets.UTF_8);
            Message message = new Message("TopicE", "myTag", body);
            // 事先埋入用户属性
            message.putUserProperty("age", i + "");

            SendResult sendResult = producer.send(message);
            System.out.println(sendResult);
        }

        producer.shutdown();
    }
}
