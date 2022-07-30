package com.hermes.netty.server.session;

/**
 * @author liu.zongbin
 * @since 2022/7/16 16:15
 */
public class SessionFactory {

    private static final Session SESSION = new SessionMemoryImpl();

    public static Session getSession() {
        return SESSION;
    }
}
