package com.hermes.designpattern.ovserver.improve;

/**
 * @author liu.zongbin
 * @since 2022/8/24 21:15
 */
public interface Observer {

    void update(float temperature, float pressure, float humidity);
}
