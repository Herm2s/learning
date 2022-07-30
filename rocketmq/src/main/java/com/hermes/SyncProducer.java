package com.hermes;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * 同步发送消息
 *
 * @author liu.zongbin
 * @created 2022/7/29 22:49
 */
@Slf4j
public class SyncProducer {

    public static void main(String[] args) throws Exception {
        // 创建一个producer
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("rocketmqOS:9876");
        // 设置发送失败时重试次数，默认2次
        producer.setRetryTimesWhenSendFailed(3);
        // 设置发送超时时限为5s，默认3s
        producer.setSendMsgTimeout(5000);
        producer.start();
        for (int i = 0; i < 10; i++) {
            byte[] body = ("Hi," + i).getBytes(StandardCharsets.UTF_8);
            Message msg = new Message("someTopic", "someTag", body);
            // 为消息指定key
            msg.setKeys("key-" + i);
            SendResult sendResult = producer.send(msg);
            log.info(sendResult.toString());
        }
        producer.shutdown();
    }
}
