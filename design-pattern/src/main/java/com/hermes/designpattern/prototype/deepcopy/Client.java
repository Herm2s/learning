package com.hermes.designpattern.prototype.deepcopy;

/**
 * @author liu.zongbin
 * @since 2022/8/14 22:02
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype p = new DeepPrototype();
        p.setName("宋江");
        p.setDeepCloneableTarget(new DeepCloneableTarget("大牛,", "小牛"));

        // 深拷贝方式1
        DeepPrototype p1 = p.clone();

        // 深拷贝方式2
        DeepPrototype p2 = p.deepClone();

        System.out.println("p.name = " + p.getName() + " p.deepCloneableTarget = " + p.getDeepCloneableTarget().hashCode());
        System.out.println("p1.name = " + p1.getName() + " p1.deepCloneableTarget = " + p1.getDeepCloneableTarget().hashCode());
        System.out.println("p2.name = " + p2.getName() + " p2.deepCloneableTarget = " + p2.getDeepCloneableTarget().hashCode());
    }
}
