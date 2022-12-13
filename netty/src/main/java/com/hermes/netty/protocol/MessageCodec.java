package com.hermes.netty.protocol;

import com.hermes.netty.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 消息编解码器
 * ● 魔数：用来在第一时间判定接收的数据是否为无效数据包
 * ● 版本号：可以支持协议的升级
 * ● 序列化算法：消息正文到底采用哪种序列化反序列化方式。如：json、protobuf、hessian、jdk
 * ● 指令类型：是登录、注册、单聊、群聊… 跟业务相关
 * ● 请求序号：为了双工通信，提供异步能力
 * ● 正文长度
 * ● 消息正文
 *
 * @author liu.zongbin
 * @since 2022/7/16 14:48
 */
@Slf4j
public class MessageCodec extends ByteToMessageCodec<Message> {

    @Override
    public void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        // 1. 4个字节的魔数
        out.writeBytes("HERM".getBytes());
        // 2. 1个字节的版本号
        out.writeByte(1);
        // 3. 1个字节的序列化方式 jdk 0, json 1
        out.writeByte(0);
        // 4. 1个字节的指令类型
        out.writeByte(msg.getMessageType());
        // 5. 4个字节的请求序号
        out.writeInt(msg.getSequenceId());
        // 无意义，对齐填充
        out.writeByte(0xff);
        // 6. 获取消息内容的字节数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(msg);
        byte[] bytes = bos.toByteArray();
        // 7. 长度
        out.writeInt(bytes.length);
        // 8. 写入消息内容
        out.writeBytes(bytes);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 读出魔数（一个Int占4个字节）
        int magicNum = in.readInt();
        byte version = in.readByte();
        byte serializerType = in.readByte();
        byte messageType = in.readByte();
        int sequenceId = in.readInt();
        in.readByte();
        // 读出消息内容
        int length = in.readInt();
        byte[] bytes = new byte[length];
        in.readBytes(bytes, 0, length);
        if (serializerType == 0) {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
            Message message = (Message) ois.readObject();
            log.debug("{},{},{},{},{},{}", magicNum, version, serializerType, messageType, sequenceId, length);
            log.debug("{}", message);
            out.add(message);
        }
    }
}

