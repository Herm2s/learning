package com.hermes.netty.server.handler;

import com.hermes.netty.message.RpcResponseMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.Promise;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liu.zongbin
 * @since 2022/7/16 22:41
 */
@Slf4j
@ChannelHandler.Sharable
public class RpcResponseMessageHandler extends SimpleChannelInboundHandler<RpcResponseMessage> {

    public static final Map<Integer, Promise<Object>> SEQ_ID_2_PROMISE_MAP = new ConcurrentHashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcResponseMessage message) throws Exception {
        log.debug("{}", message);
        // 拿到Promise
        Promise<Object> promise = SEQ_ID_2_PROMISE_MAP.remove(message.getSequenceId());

        if (promise != null) {
            Object returnValue = message.getReturnValue();
            Exception exceptionValue = message.getExceptionValue();
            if (exceptionValue == null) {
                promise.setSuccess(returnValue);
            } else {
                promise.setFailure(exceptionValue);
            }
        }
    }
}
