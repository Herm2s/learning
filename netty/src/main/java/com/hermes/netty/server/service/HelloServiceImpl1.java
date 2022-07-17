package com.hermes.netty.server.service;

/**
 * @author liu.zongbin
 * @since 2022/7/17 14:35
 */
public class HelloServiceImpl1 implements HelloService {
    @Override
    public String sayHello(String msg) {
        return "null, " + msg;
    }
}
