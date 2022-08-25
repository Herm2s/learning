package com.hermes.designpattern.mediator;

/**
 * @author liu.zongbin
 * @since 2022/8/25 19:44
 */
public class Client {

    public static void main(String[] args) {
        // 创建中介者
        Mediator mediator = new ConcreteMediator();

        // 创建各种同事类
        Alarm alarm = new Alarm(mediator, "Alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "CoffeeMachine");
        Curtains curtains = new Curtains(mediator, "Curtains");
        TV tv = new TV(mediator, "TV");

        // 发出消息
        alarm.sendAlarm(0);
        coffeeMachine.finishCoffee();
        alarm.sendAlarm(1);
    }
}
