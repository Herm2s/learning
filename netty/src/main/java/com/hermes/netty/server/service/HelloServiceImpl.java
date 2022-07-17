package com.hermes.netty.server.service;

/**
 * @author liu.zongbin
 * @since 2022/7/16 22:43
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String msg) {
        return "你好, " + msg;
    }
}
