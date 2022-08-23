package com.hermes.designpattern.ovserver;

/**
 * @author liu.zongbin
 * @since 2022/8/23 22:17
 */
public class Client {

    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);

        weatherData.setData(30, 150, 40);

        System.out.println("============天气情况变化=============");
        weatherData.setData(40, 160, 20);
    }
}
