package com.hermes.designpattern.mediator;

/**
 * @author liu.zongbin
 * @since 2022/8/25 19:55
 */
public class CoffeeMachine extends Colleague {

    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        // 将自己放入具体中介者的集合中
        mediator.register(name, this);
    }

    public void startCoffee() {
        System.out.println("开始煮咖啡");
    }

    public void finishCoffee() {
        System.out.println("五分钟之后...");
        System.out.println("咖啡煮好了");
        this.sendMessage(0);
    }

    @Override
    public void sendMessage(int stateChange) {
        // 调用中介者对象的getMessage
        this.getMediator().getMessage(stateChange, this.getName());
    }
}
