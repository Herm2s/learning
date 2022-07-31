package com.hermes.delay;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 延迟消息
 *
 * @author liu.zongbin
 * @created 2022/7/30 19:58
 */
public class DelayProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("rocketmqOS:9876");
        producer.start();

        for (int i = 0; i < 100; i++) {
            byte[] body = ("Hi, " + i).getBytes(StandardCharsets.UTF_8);
            Message message = new Message("TopicB", "TagB", body);
            // 指定消息延迟等级为3：延迟10s
            message.setDelayTimeLevel(3);
            SendResult sendResult = producer.send(message);
            // 输出消息被发送的时间
            System.out.print(new SimpleDateFormat("mm:ss").format(new Date()));
            System.out.println(", " + sendResult);
        }
        producer.shutdown();
    }
}
