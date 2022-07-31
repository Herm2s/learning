package com.hermes.retry;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *  拉取模式消费者
 *
 * @author liu.zongbin
 * @created 2022/7/29 23:41
 */
@Slf4j
public class RetryConsumer {

    public static void main(String[] args) throws MQClientException {
        // 定义一个拉取模式消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("cg");
        // 定义一个推送模式消费者
//        DefaultLitePullConsumer pullConsumer = new DefaultLitePullConsumer();
        consumer.setNamesrvAddr("rocketmqOS:9876");
        // 指定从第一条开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 指定消费的topic和tag
        consumer.subscribe("someTopic", "*");
        // 采用广播模式进行消费，默认为集群模式
//        consumer.setMessageModel(MessageModel.BROADCASTING);
        // 注册消息监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                // 逐条消息模式
                for (MessageExt msg : msgs) {
                    log.info(new String(msg.getBody(), StandardCharsets.UTF_8));
                }
                // 返回消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        log.info("Consumer Started");
    }
}
