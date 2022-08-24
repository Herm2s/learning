package com.hermes.designpattern.ovserver.improve;

/**
 * @author liu.zongbin
 * @since 2022/8/24 21:15
 */
public class BaiduSite implements Observer {

    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.display();
    }

    public void display() {
        System.out.println("=====百度网站=====");
        System.out.println("***百度网站 气温：" + temperature + "***");
        System.out.println("***百度网站 气压：" + pressure + "***");
        System.out.println("***百度网站 湿度：" + humidity + "***");
    }
}
