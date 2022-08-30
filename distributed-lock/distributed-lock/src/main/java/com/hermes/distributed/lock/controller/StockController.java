package com.hermes.distributed.lock.controller;

import com.hermes.distributed.lock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu.zongbin
 * @since 2022/8/30 21:50
 */
@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/stock/deduct")
    public String deduct() {
        this.stockService.deduct();
        return "hello stock deduct";
    }
}
