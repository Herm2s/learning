package com.hermes.netty.server.handler;

import com.hermes.netty.message.LoginRequestMessage;
import com.hermes.netty.message.LoginResponseMessage;
import com.hermes.netty.server.service.UserServiceFactory;
import com.hermes.netty.server.session.SessionFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author liu.zongbin
 * @since 2022/7/16 17:28
 */
@ChannelHandler.Sharable
public class LoginRequestMessageHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage msg) throws Exception {
        String username = msg.getUsername();
        String password = msg.getPassword();
        boolean success = UserServiceFactory.getUserService().login(username, password);
        LoginResponseMessage responseMessage;
        if (success) {
            SessionFactory.getSession().bind(ctx.channel(), username);
            responseMessage = new LoginResponseMessage(true, "登录成功");
        } else {
            responseMessage = new LoginResponseMessage(false, "用户名或密码不正确");
        }
        ctx.writeAndFlush(responseMessage);
    }
}
