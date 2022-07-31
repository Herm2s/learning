package com.hermes.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 顺序消息
 *
 * @author liu.zongbin
 * @created 2022/7/30 19:58
 */
public class OrderedProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("rocketmqOS:9876");
        // 若为全局有序则需要设置Queue数量为1
//        producer.setDefaultTopicQueueNums(1);
        producer.start();

        for (int i = 0; i < 100; i++) {
            int orderId = i;
            byte[] body = ("Hi, " + i).getBytes(StandardCharsets.UTF_8);
            Message message = new Message("TopicA", "TagA", body);
            // 将orderId作为消息key
            message.setKeys(Integer.toString(orderId));
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    // 使用消息key作为选择的选择算法
                    String keys = msg.getKeys();
                    int orderId = Integer.parseInt(keys);
                    // 也可以使用arg作为选择key的选择算法
//                    Integer orderId = (Integer) arg;
                    int index = orderId % mqs.size();
                    return mqs.get(index);
                }
            }, orderId);
            System.out.println(sendResult);
        }
        producer.shutdown();
    }
}
