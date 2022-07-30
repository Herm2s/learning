package com.hermes.netty.netty.c5;

import com.hermes.netty.message.LoginRequestMessage;
import com.hermes.netty.protocol.MessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author liu.zongbin
 * @since 2022/7/16 15:09
 */
public class TestMessageCodec {
    public static void main(String[] args) throws Exception {
        EmbeddedChannel channel = new EmbeddedChannel(
                // 添加帧解码器，避免粘包半包问题
                new LengthFieldBasedFrameDecoder(1024, 12, 4, 0, 0),
                new LoggingHandler(LogLevel.DEBUG),
                new MessageCodec());
        // encode
        LoginRequestMessage message = new LoginRequestMessage("hermes", "123");
        // decode
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        channel.writeOutbound(message);
        new MessageCodec().encode(null, message, buf);
        channel.writeInbound(buf);
    }
}
