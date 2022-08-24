package com.hermes.designpattern.ovserver.improve;

/**
 * @author liu.zongbin
 * @since 2022/8/24 21:14
 */
public class Client {

    public static void main(String[] args) {
        // 创建气象站
        WeatherData weatherData = new WeatherData();

        // 创建观察者
        SinaSite sinaSite = new SinaSite();
        BaiduSite baiduSite = new BaiduSite();

        // 注册观察者
        weatherData.registerObserver(sinaSite);
        weatherData.registerObserver(baiduSite);

        // 测试
        System.out.println("通知各个观察者，看看信息");
        weatherData.setData(10f, 100f, 30.3f);


        weatherData.removeObserver(sinaSite);
        // 测试
        System.out.println();
        System.out.println("通知各个观察者，看看信息");
        weatherData.setData(10f, 100f, 30.3f);
    }
}
