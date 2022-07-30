package com.hermes.netty.server.service;

/**
 * @author liu.zongbin
 * @since 2022/7/16 16:09
 */
public abstract class UserServiceFactory {

    private static final UserService userService = new UserServiceMemoryImpl();

    public static UserService getUserService() {
        return userService;
    }
}
