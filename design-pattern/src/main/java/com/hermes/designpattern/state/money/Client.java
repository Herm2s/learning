package com.hermes.designpattern.state.money;

/**
 * @author liu.zongbin
 * @since 2022/8/30 21:31
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new PublishState());
        System.out.println(context.getCurrentState());

        // publish --> not pay
        context.acceptOrderEvent(context);
        // not pay --> paid
        context.payOrderEvent(context);
    }
}
