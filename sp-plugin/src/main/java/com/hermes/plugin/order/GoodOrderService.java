package com.hermes.plugin.order;

import org.springframework.stereotype.Service;

/**
 * @author liu.zongbin
 * @since 2022/11/11
 */
@Service
public class GoodOrderService implements OrderPlugin {

    @Override
    public void createOrder() {
        System.out.println("创建商品订单");
    }

    @Override
    public boolean supports(OrderEnum delimiter) {
        return OrderEnum.GOOD.equals(delimiter);
    }
}
