package com.hermes.designpattern.ovserver.improve;

/**
 * @author liu.zongbin
 * @since 2022/8/24 21:19
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
