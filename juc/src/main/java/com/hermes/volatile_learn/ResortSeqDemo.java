package com.hermes.volatile_learn;

/**
 * 指令重排序
 *
 * @author liu.zongbin
 * @created 2022/6/27 14:00
 */
public class ResortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void method1() {
        a = 1;
        flag = true;
    }

    public void method2() {
        if (flag) {
            a = a + 5;
            System.out.println("reValue: " + a);
        }
    }

}
