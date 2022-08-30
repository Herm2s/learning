package com.hermes.distributed.lock.service;

import com.hermes.distributed.lock.pojo.Stock;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu.zongbin
 * @since 2022/8/30 21:49
 */
@Service
public class StockService {

    private Stock stock = new Stock();

    private ReentrantLock lock = new ReentrantLock();

    public void deduct() {
        try {
            this.lock.lock();
            stock.setStock(stock.getStock() - 1);
        } finally {
            this.lock.unlock();
        }
        System.out.println("库存余量：" + this.stock.getStock());
    }
}
