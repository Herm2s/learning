package com.hermes.designpattern.mediator;

/**
 * @author liu.zongbin
 * @since 2022/8/25 19:50
 */
public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        // 将自己放入具体中介者的集合中
        mediator.register(name, this);
    }

    public void sendAlarm(int stateChange) {
        this.sendMessage(stateChange);
    }

    @Override
    public void sendMessage(int stateChange) {
        // 调用中介者对象的getMessage
        this.getMediator().getMessage(stateChange, this.getName());
    }
}
