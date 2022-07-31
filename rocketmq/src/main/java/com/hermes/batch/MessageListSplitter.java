package com.hermes.batch;

import org.apache.rocketmq.common.message.Message;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 消息列表分割器
 * 只会处理每条消息不超过4M的情况
 * 若某条消息本身大于4M，分割器无法处理，直接将消息返回
 * @author liu.zongbin
 * @created 2022/7/31 18:33
 */
public class MessageListSplitter implements Iterator<List<Message>> {

    private final int SIZE_LIMIT = 4 * 1024 * 1024;

    private final List<Message> messages;

    private int currentIndex;

    public MessageListSplitter(List<Message> messages) {
        this.messages = messages;
    }


    @Override
    public boolean hasNext() {
        return currentIndex < this.messages.size();
    }

    @Override
    public List<Message> next() {
        int nextIndex = this.currentIndex;
        // 当前要发送的这一小批消息列表的大小
        int totalSize = 0;
        for (; nextIndex < this.messages.size(); nextIndex++) {
            Message message = this.messages.get(nextIndex);

            // message长度 = topic长度 + body长度 + log长度（固定20字节）+ properties总长度
            int tmpSize = message.getTopic().length() + message.getBody().length;
            Map<String, String> properties = message.getProperties();
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                tmpSize += entry.getKey().length() + entry.getValue().length();
            }
            tmpSize += 20;

            // 当前消息本身是否大于4M
            if (tmpSize > SIZE_LIMIT) {
                // 判断超过4M的消息是不是本次获取的第一条消息
                if (nextIndex - this.currentIndex == 0) {
                    // 是的话就直接返回这条消息
                    nextIndex++;
                }
                // 不是的话直接返回不包括超过4M消息的列表
                // 超过4M的消息会在下次调用next的时候返回
                break;
            }

            if (tmpSize + totalSize > SIZE_LIMIT) {
                break;
            } else {
                totalSize += tmpSize;
            }
        } // end for
        // 截取当前message列表的子集合[currentIndex, nextIndex)
        List<Message> subList = this.messages.subList(this.currentIndex, nextIndex);
        // 下次遍历的开始索引
        this.currentIndex = nextIndex;
        return subList;
    }
}
