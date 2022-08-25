package com.hermes.designpattern.mediator;

/**
 * @author liu.zongbin
 * @since 2022/8/25 19:58
 */
public class TV extends Colleague {

    public TV(Mediator mediator, String name) {
        super(mediator, name);
        // 将自己放入具体中介者的集合中
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.getName());
    }

    public void startTV() {
        System.out.println("开启电视");
    }

    public void closeTV() {
        System.out.println("关闭电视");
    }
}
