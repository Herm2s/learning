package com.hermes.netty.server.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liu.zongbin
 * @since 2022/7/16 16:10
 */
public class UserServiceMemoryImpl implements UserService {

    private final Map<String, String> allUserMap = new ConcurrentHashMap<>();
    {
        allUserMap.put("zhangsan", "123");
        allUserMap.put("lisi", "123");
        allUserMap.put("wangwu", "123");
        allUserMap.put("zhaoliu", "123");
        allUserMap.put("qianqi", "123");
    }

    @Override
    public boolean login(String username, String password) {

        final String pass = allUserMap.get(username);
        if (pass == null) {
            return false;
        }

        return pass.equals(password);
    }
}
