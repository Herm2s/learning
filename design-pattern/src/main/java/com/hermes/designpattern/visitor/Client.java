package com.hermes.designpattern.visitor;

/**
 * @author liu.zongbin
 * @since 2022/8/22 22:07
 */
public class Client {

    public static void main(String[] args) {
        // 创建objectStructure
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        // 成功
        Success success = new Success();
        objectStructure.display(success);
        System.out.println("===============");

        // 失败
        Fail fail = new Fail();
        objectStructure.display(fail);
        System.out.println("===============");

        // 待定
        Wait wait = new Wait();
        objectStructure.display(wait);
    }
}
