package com.hermes.netty.netty.c5;

import com.hermes.netty.config.Config;
import com.hermes.netty.message.LoginRequestMessage;
import com.hermes.netty.message.Message;
import com.hermes.netty.protocol.MessageCodecSharable;
import com.hermes.netty.protocol.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author liu.zongbin
 * @since 2022/7/16 20:00
 */
public class TestSerializer {

    public static void main(String[] args) {
        MessageCodecSharable codec = new MessageCodecSharable();
        LoggingHandler loggingHandler = new LoggingHandler();
        EmbeddedChannel channel = new EmbeddedChannel(loggingHandler, codec, loggingHandler);

        LoginRequestMessage message = new LoginRequestMessage("zhangsan", "123");
        //channel.writeOutbound(message);
        channel.writeInbound(messageToBytes(message));
    }

    public static ByteBuf messageToBytes(Message message) {
        int algorithm = Config.getSerializerAlgorithm().ordinal();
        ByteBuf out = ByteBufAllocator.DEFAULT.buffer();
        out.writeBytes("herm".getBytes());
        out.writeByte(1);
        out.writeByte(algorithm);
        out.writeByte(message.getMessageType());
        out.writeInt(message.getSequenceId());
        out.writeByte(0xff);
        byte[] bytes = Serializer.Algorithm.values()[algorithm].serialize(message);
        out.writeInt(bytes.length);
        out.writeBytes(bytes);
        return out;
    }
}
