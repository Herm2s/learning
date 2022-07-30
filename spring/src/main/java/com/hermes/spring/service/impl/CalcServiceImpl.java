package com.hermes.spring.service.impl;

import com.hermes.spring.service.CalcService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.*;

/**
 * @author liu.zongbin
 * @created 2022/6/30 13:20
 */
@Service
public class CalcServiceImpl implements CalcService {

    @Override
    @Transactional
    public int div(int x, int y) {
        int result = x / y;
        System.out.println("=========>CalcServiceImpl被调用了,我们的计算结果：" + result);
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread t1 = new Thread(() -> {
//            System.out.println(1 / 0);
//        }, "thread a");
//        t1.setUncaughtExceptionHandler((t, e) -> {
//            System.out.println("当前线程：" + Thread.currentThread().getName());
//            System.out.println("发生异常的线程：" + t.getName());
//            System.out.println("异常信息：" + e.getMessage());
//        });
//        t1.start();

        FutureTask<Integer> task = new FutureTask(() -> 1 / 0);
        new Thread(task).start();
        task.get();
    }
}
