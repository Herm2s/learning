package com.hermes.general;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * 单向消息发送
 *
 * @author liu.zongbin
 * @created 2022/7/29 22:49
 */
@Slf4j
public class OneWayProducer {

    public static void main(String[] args) throws Exception {
        // 创建一个producer
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("rocketmqOS:9876");
        producer.start();

        for (int i = 0; i < 10; i++) {
            byte[] body = ("Hi," + i).getBytes(StandardCharsets.UTF_8);
            Message msg = new Message("single", "someTag", body);
            // 发送单向消息
            producer.sendOneway(msg);
        }
        producer.shutdown();
    }
}
