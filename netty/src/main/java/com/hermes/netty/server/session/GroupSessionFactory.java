package com.hermes.netty.server.session;

/**
 * @author liu.zongbin
 * @since 2022/7/16 16:13
 */
public class GroupSessionFactory {

    private static final GroupSession SESSION = new GroupSessionMemoryImpl();

    public static GroupSession getGroupSession() {
        return SESSION;
    }
}
