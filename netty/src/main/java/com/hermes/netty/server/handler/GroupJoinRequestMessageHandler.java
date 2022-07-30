package com.hermes.netty.server.handler;

import com.hermes.netty.message.GroupJoinRequestMessage;
import com.hermes.netty.message.GroupJoinResponseMessage;
import com.hermes.netty.server.session.GroupSession;
import com.hermes.netty.server.session.GroupSessionFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author liu.zongbin
 * @since 2022/7/16 17:54
 */
@ChannelHandler.Sharable
public class GroupJoinRequestMessageHandler extends SimpleChannelInboundHandler<GroupJoinRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupJoinRequestMessage msg) throws Exception {
        GroupSession groupSession = GroupSessionFactory.getGroupSession();
        groupSession.joinMember(msg.getGroupName(), msg.getUsername());
        ctx.channel().writeAndFlush(new GroupJoinResponseMessage(true, "您已成功加入群聊：" + msg.getGroupName()));
        System.out.println(groupSession.getMembers(msg.getGroupName()));
    }
}
