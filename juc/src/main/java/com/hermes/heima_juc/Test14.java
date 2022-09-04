package com.hermes.heima_juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liu.zongbin
 * @since 2022/9/4 16:40
 */
@Slf4j
/**
 * 使用volatile设置打断标记，实现两阶段终止
 */
public class Test14 {
    public static void main(String[] args) throws InterruptedException {
        TwoParseTermination1 twoParseTermination = new TwoParseTermination1();
        twoParseTermination.start();
        // 让监控线程执行一会儿
        Thread.sleep(3000);
        // 停止监控线程
        twoParseTermination.stop();
    }
}

@Slf4j
class TwoParseTermination1 {
    Thread thread;

    /**
     * 设置打断标记为volatile，解决主线程修改对thread线程的可见性问题
     */
    private volatile boolean stop = false;

    private boolean starting = false;

    public void start() {
        // 如果不加锁，多个线程同时进入if进行判断的话就会出问题，所以要加锁！synchronized同时保证了可见性和原子性，
        // 所以这里的starting没有使用volatile
        synchronized (this) {
            if (starting) {
                return;
            }
            starting = true;
        }

        thread = new Thread(() -> {
            while (true) {
                if (stop) {
                    log.debug("线程结束。。正在料理后事中");
                    break;
                }
                try {
                    Thread.sleep(500);
                    log.debug("正在执行监控的功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void stop() {
        this.stop = true;
        // 这里打断是为了防止如果线程在执行Thread.sleep(500);时，要等待一定时间才停止
        thread.interrupt();
    }
}
