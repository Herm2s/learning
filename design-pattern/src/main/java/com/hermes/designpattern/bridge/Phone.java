package com.hermes.designpattern.bridge;

/**
 * @author liu.zongbin
 * @since 2022/8/17 22:09
 */
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        this.brand.close();
    }

    protected void call() {
        this.brand.call();
    }
}
