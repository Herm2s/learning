package com.hermes.netty.server.handler;

import com.hermes.netty.message.GroupQuitRequestMessage;
import com.hermes.netty.message.GroupQuitResponseMessage;
import com.hermes.netty.server.session.GroupSession;
import com.hermes.netty.server.session.GroupSessionFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author liu.zongbin
 * @since 2022/7/16 17:55
 */
@ChannelHandler.Sharable
public class GroupQuitRequestMessageHandler extends SimpleChannelInboundHandler<GroupQuitRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupQuitRequestMessage msg) throws Exception {
        GroupSession groupSession = GroupSessionFactory.getGroupSession();
        groupSession.removeMember(msg.getGroupName(), msg.getUsername());
        ctx.channel().writeAndFlush(new GroupQuitResponseMessage(true, "您已成功退出群聊：" + msg.getGroupName()));
    }
}
