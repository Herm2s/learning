package com.hermes.netty.netty.c1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class HelloServer {

    public static void main(String[] args) {
        // 1. 启动器，负责组装Netty组件，启动服务器
        new ServerBootstrap()
                // 2. BossEventLoop， WorkerEventLoop（selector,thread) group 组
                .group(new NioEventLoopGroup())
                // 3. 虚着呢服务器的ServerSocketChannel实现
                .channel(NioServerSocketChannel.class)
                // 4. boss 负责处理链接，worker（child）负责处理读写，决定了worker能执行哪些操作
                .childHandler(
                        // 5. 初始化channel，添加handler处理器
                        new ChannelInitializer<NioSocketChannel>() {
                            @Override
                            protected void initChannel(NioSocketChannel ch) {
                                //6. 添加具体handler
                                ch.pipeline().addLast(new StringDecoder());
                                ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx, Object msg) {
                                        System.out.println(msg);
                                    }
                                });
                            }
                        })
                // 7. 绑定端口
                .bind(8080);
    }
}
