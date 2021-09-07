package com.hermes.sync;

import java.util.concurrent.TimeUnit;

/**
 * 1. 标准访问，先打印短信还是邮件 ———— 先短信，后邮件
 * 2. 停4秒在短信方法内，先打印短信还是邮件 ———— 等待4秒后，先短信，后邮件
 * 3. 新增普通的hello方法，先打印短信还是hello ———— 先hello，等待4秒后，短信
 * 4. 现在有两部手机，先打印短信还是邮件 ———— 先邮件，等待4秒后，短信
 * 5. 两个静态同步方法，1部手机，先打印短信还是邮件 ———— 等待4秒后，先短信，后邮件
 * 6. 两个静态同步方法，2部手机，先打印短信还是邮件 ———— 等待4秒后，先短信，后邮件
 * 7. 1个静态同步方法，1个普通同步方法，1部手机，先打印短信还是邮件 ———— 先邮件，等待4秒后，短信
 * 8. 1个静态同步方法，1个普通同步方法，2部手机，先打印短信还是邮件 ———— 先邮件，等待4秒后，短信
 * <p>
 * synchronized总结：
 * 对于普通同步方法，锁的是当前实例对象
 * 对于静态同步方法，锁的是当前类的Class对象
 * 对于同步方法块，锁的是synchronized括号里配置的对象
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/4
 */
class Phone {

    public static synchronized void sendSMS() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("--------sendSMS");
    }

    public static synchronized void sendEmail() {
        System.out.println("--------sendEmail");
    }

    public void getHello() {
        System.out.println("--------getHello");
    }
}

public class Lock_8 {
    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        Thread.sleep(100);

        new Thread(() -> {
            phone.sendEmail();
        }, "BB").start();
    }
}

