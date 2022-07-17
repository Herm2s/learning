package com.hermes.netty.server.service;

/**用户管理接口
 * @author liu.zongbin
 * @since 2022/7/16 16:08
 */
public interface UserService {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回 true, 否则返回 false
     */
    boolean login(String username, String password);
}
