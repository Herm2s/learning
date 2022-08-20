package com.hermes.designpattern.flyweight;

/**
 * @author liu.zongbin
 * @since 2022/8/20 16:19
 */
public class ConcreteWebSite extends WebSite {

    /**
     * 网站类型
     * 共享的部分，内部状态
     */
    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println(type + "类型的网站在使用中，使用者是：" + user.getName());
    }
}
