package com.hermes.distributed.lock.service;

import com.hermes.distributed.lock.pojo.Stock;
import org.springframework.stereotype.Service;

/**
 * @author liu.zongbin
 * @since 2022/8/30 21:49
 */
@Service
public class StockService {

    private Stock stock = new Stock();

    public void deduct() {
        stock.setStock(stock.getStock() - 1);
        System.out.println("库存余量：" + this.stock.getStock());
    }
}
