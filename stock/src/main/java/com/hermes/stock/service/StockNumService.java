package com.hermes.stock.service;

import com.hermes.stock.mapper.StockNumMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author liu.zongbin
 * @since 2023/2/6
 */
@Service
@RequiredArgsConstructor
public class StockNumService {

    private final StockNumMapper stockNumMapper;

    public void reduce() {
        this.stockNumMapper.reduce(1L);
    }
}
