package com.hermes.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author liu.zongbin
 * @since 2022/8/1 11:30
 */
@Slf4j
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    log.debug("线程任务执行");
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    log.debug("被打断");
                }
            }
        };
        t1.start();
        TimeUnit.MILLISECONDS.sleep(500L);
        //log.debug("111是否被打断？{}",t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        //log.debug("222是否被打断？{}",t1.isInterrupted());
        //Thread.sleep(500);
        //log.debug("222是否被打断？{}",t1.isInterrupted());
        //log.debug("主线程");
    }
}
