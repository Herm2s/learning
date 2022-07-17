package com.hermes.netty.netty.c1;

import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TestEventLoop {

    public static void main(String[] args) {
        // 1. 创建工作组
        NioEventLoopGroup group = new NioEventLoopGroup(2);
        // 2. 获取下一个事件循环对象
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());

        // 3. 执行普通任务
      /*  group.next().execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("ok");
        });
        */
        // 4. 执行定时任务
        group.next().scheduleAtFixedRate(() -> log.debug("ok"), 0L, 1L, TimeUnit.SECONDS);
        log.debug("main");
    }
}
