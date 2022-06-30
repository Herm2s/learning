package com.hermes.cas;

import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用
 *
 * @author liu.zongbin
 * @created 2022/6/27 15:07
 */
@Data
class User {
    String userName;
    int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}

public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User z3 = new User("z3", 22);

        User l4 = new User("l4", 25);


        // 创建原子引用包装类
        AtomicReference<User> atomicReference = new AtomicReference<>();

        // 现在主物理内存的共享变量，为z3
        atomicReference.set(z3);

        // 比较并交换，如果现在主物理内存的值为z3，那么交换成l4
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t " + atomicReference.get().toString());

        // 比较并交换，现在主物理内存的值是l4了，但是预期为z3，因此交换失败
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t " + atomicReference.get().toString());
    }
}
