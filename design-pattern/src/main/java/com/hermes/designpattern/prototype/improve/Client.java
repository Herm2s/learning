package com.hermes.designpattern.prototype.improve;

/**
 * @author liu.zongbin
 * @since 2022/8/14 21:05
 */
public class Client {

    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom", 1, "白色");
        sheep.setFriend(new Sheep("jack", 2, "黑色"));

        Sheep sheep1 = sheep.clone();
        Sheep sheep2 = sheep.clone();
        Sheep sheep3 = sheep.clone();
        Sheep sheep4 = sheep.clone();
        Sheep sheep5 = sheep.clone();
        Sheep sheep6 = sheep.clone();
        Sheep sheep7 = sheep.clone();
        Sheep sheep8 = sheep.clone();
        Sheep sheep9 = sheep.clone();
        Sheep sheep10 = sheep.clone();

        System.out.println("sheep1 = " + sheep1 + " sheep1.friend = " + sheep1.getFriend().hashCode());
        System.out.println("sheep2 = " + sheep1 + " sheep2.friend = " + sheep2.getFriend().hashCode());
    }
}
