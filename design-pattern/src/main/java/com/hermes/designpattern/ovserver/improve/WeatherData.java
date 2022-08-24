package com.hermes.designpattern.ovserver.improve;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/8/24 21:20
 */
public class WeatherData implements Subject {

    @Getter
    private float temperature;
    @Getter
    private float pressure;
    @Getter
    private float humidity;

    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void dataChange() {
        this.notifyObservers();
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dataChange();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.temperature, this.pressure, this.humidity);
        }
    }
}
