package com.hermes;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * 异步发送消息
 *
 * @author liu.zongbin
 * @created 2022/7/29 22:49
 */
@Slf4j
public class AsyncProducer {

    public static void main(String[] args) throws Exception {
        // 创建一个producer
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("rocketmqOS:9876");
        // 指定异步发送失败后不进行重试
        producer.setRetryTimesWhenSendAsyncFailed(0);
        // 指定新创建的Topic的Queue数量为2，默认为4
        producer.setDefaultTopicQueueNums(2);
        producer.start();

        for (int i = 0; i < 10; i++) {
            byte[] body = ("Hi," + i).getBytes(StandardCharsets.UTF_8);
            Message msg = new Message("someTopicB", "someTagB", body);
            // 指定回调
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info(sendResult.toString());
                }

                @Override
                public void onException(Throwable e) {
                    e.printStackTrace();
                }
            });
        }
        // sleep一会儿，等待异步发送完毕
        TimeUnit.SECONDS.sleep(3L);
        producer.shutdown();
    }
}
