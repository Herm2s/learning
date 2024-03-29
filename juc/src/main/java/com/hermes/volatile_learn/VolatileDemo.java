package com.hermes.volatile_learn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Volatile Java虚拟机提供的轻量级同步机制
 * 可见性（及时通知）
 * 不保证原子性
 * 禁止指令重排序
 *
 * @author liu.zongbin
 * @created 2022-06-17
 */
class MyData {

    /**
     * volatile 修饰的关键字，是为了增加 主线程和线程之间的可见性，只要有一个线程修改了内存中的值，其它线程也能马上感知
     */
    volatile int number = 0;

    /**
     *  创建一个原子Integer包装类，默认为0
     */
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic() {
        // 相当于 atomicInter ++
        atomicInteger.getAndIncrement();
    }

    public void changeTo60() {
        this.number = 60;
    }

    /**
     * 注意，此时number 前面是加了volatile修饰
     */
    public synchronized void addPlusPlus() {
        number++;
    }
}

/**
 * 验证volatile的可见性
 * 1. 假设int number = 0，number变量之前没有添加volatile关键字修饰
 * 2。添加了volatile，可以解决可见性问题
 * <p>
 * 验证volatile不保证原子性
 * 1、原子性指的是什么意思？
 */
public class VolatileDemo {
    /**
     * 验证原子性
     */
    public static void main(String[] args) {
        MyData myData = new MyData();
        // 创建10个线程，线程里面进行1000次循环
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                // 里面
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
        while (Thread.activeCount() > 2) {
            // yield表示不执行
            Thread.yield();
        }
        // 查看最终的值
        // 假设volatile保证原子性，那么输出的值应该为：  20 * 1000 = 20000
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally atomicNumber value: " + myData.atomicInteger);
    }

//    /**
//     * 验证可见性
//     */
//    public static void main(String[] args) {
//        // 资源类
//        MyData myData = new MyData();
//        // AAA线程 实现了Runnable接口
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + "\t come in");
//            // 线程睡眠3秒，假设在进行运算
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            // 修改number的值
//            myData.changeTo60();
//            // 输出修改后的值
//            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);
//        }, "AAA").start();
//
//        // 主线程
//        while (myData.number == 0) {
//            // main线程就一直在这里等待循环，直到number的值不等于零
//        }
//        // 按道理这个值是不可能打印出来的，因为主线程运行的时候，number的值为0，所以一直在循环
//        // 如果能输出这句话，说明AAA线程在睡眠3秒后，更新的number的值，重新写入到主内存，并被main线程感知到了
//        System.out.println(Thread.currentThread().getName() + "\t mission is over");
//        /*
//          最后输出结果：
//          AAA	 come in
//          AAA	 update number value:60
//          最后线程没有停止，并行没有输出  mission is over 这句话，说明没有用volatile修饰的变量，是没有可见性
//         */
//    }
}
