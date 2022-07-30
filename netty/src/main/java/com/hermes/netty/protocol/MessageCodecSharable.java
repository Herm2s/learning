package com.hermes.netty.protocol;

import com.hermes.netty.config.Config;
import com.hermes.netty.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 必须和LengthFieldBasedFrameDecoder一起使用，防止粘包和半包
 *
 * @author liu.zongbin
 * @since 2022/7/16 16:03
 */
@Slf4j
@ChannelHandler.Sharable
public class MessageCodecSharable extends MessageToMessageCodec<ByteBuf, Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> outList) throws Exception {
        ByteBuf out = ctx.alloc().buffer();
        // 1. 4个字节的魔数
        out.writeBytes("HERM".getBytes());
        // 2. 1个字节的版本号
        out.writeByte(1);
        // 3. 1个字节的序列化方式 jdk 0, json 1
        out.writeByte(Config.getSerializerAlgorithm().ordinal());
        // 4. 1个字节的指令类型
        out.writeByte(msg.getMessageType());
        // 5. 4个字节的请求序号
        out.writeInt(msg.getSequenceId());
        // 无意义，对齐填充
        out.writeByte(0xff);
        // 6. 获取消息内容的字节数组
        byte[] bytes = Config.getSerializerAlgorithm().serialize(msg);
        // 7. 长度
        out.writeInt(bytes.length);
        // 8. 写入消息内容
        out.writeBytes(bytes);

        outList.add(out);
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
        // 找到反序列化算法
        Serializer.Algorithm serializerAlgorithm = Serializer.Algorithm.values()[serializerType];
        // 确定消息类型
        Class<?> messageClass = Message.getMessageClass(messageType);
        Object message = serializerAlgorithm.deserialize(messageClass, bytes);
        //log.debug("{},{},{},{},{},{}", magicNum, version, serializerType, messageType, sequenceId, length);
        //log.debug("{}", message);
        out.add(message);
    }
}
