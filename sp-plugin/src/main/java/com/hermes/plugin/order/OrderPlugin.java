package com.hermes.plugin.order;

import org.springframework.plugin.core.Plugin;

/**
 * @author liu.zongbin
 * @since 2022/11/11
 */
public interface OrderPlugin extends Plugin<OrderEnum> {

    void createOrder();
}
