package com.hermes.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liu.zongbin
 * @created 2022/7/31 18:29
 */
public class BatchProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("rocketmqOS:9876");
        // 指定发送消息的最大大小，默认是4M
        // 不过仅修改该属性是不行的，还需要同时修改broker的配置文件中的maxMessageSize属性
//        producer.setMaxMessageSize(8 * 1024 * 1024);
        producer.start();

        // 批量消息集合
        List<Message> messages = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            byte[] body = ("Hi, " + i).getBytes(StandardCharsets.UTF_8);
            Message message = new Message("TopicD", "someTag", body);
            messages.add(message);
        }
        // 消息列表分割器
        MessageListSplitter splitter = new MessageListSplitter(messages);
        while (splitter.hasNext()) {
            List<Message> listItem = splitter.next();
            producer.send(listItem);
        }

        producer.shutdown();
    }
}
