package com.hermes.stock.controller;

import com.hermes.stock.service.StockNumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu.zongbin
 * @since 2023/2/6
 */
@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockNumService stockNumService;

    @PostMapping("/reduce")
    public void reduce() {
        this.stockNumService.reduce();
    }
}
