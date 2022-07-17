package com.hermes.netty.server.handler;

import com.hermes.netty.message.ChatRequestMessage;
import com.hermes.netty.message.ChatResponseMessage;
import com.hermes.netty.server.session.SessionFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author liu.zongbin
 * @since 2022/7/16 17:30
 */
@ChannelHandler.Sharable
public class ChatRequestMessageHandler extends SimpleChannelInboundHandler<ChatRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ChatRequestMessage msg) throws Exception {
        String to = msg.getTo();
        Channel channel = SessionFactory.getSession().getChannel(to);
        if (channel != null) {
            // 对方在线
            channel.writeAndFlush(new ChatResponseMessage(msg.getFrom(), msg.getContent()));
        } else {
            // 对方不在线
            ctx.writeAndFlush(new ChatResponseMessage(false, "对方用户不在线或不存在"));
        }
    }
}
