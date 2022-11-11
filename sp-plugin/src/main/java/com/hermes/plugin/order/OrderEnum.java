package com.hermes.plugin.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author liu.zongbin
 * @since 2022/11/11
 */
@Getter
@RequiredArgsConstructor
public enum OrderEnum {

    BOX("盲盒"),

    GOOD("商品");

    private final String name;
}
