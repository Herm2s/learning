package com.hermes.designpattern.mediator;

/**
 * @author liu.zongbin
 * @since 2022/8/25 19:45
 */
public abstract class Mediator {

    /**
     * 注册同事对象
     */
    public abstract void register(String colleagueName, Colleague colleague);

    /**
     * 接收同事对象发送的消息
     */
    public abstract void getMessage(int stateChange, String colleagueName);

    public abstract void sendMessage();
}
