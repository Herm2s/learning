package com.hermes.designpattern.adapter;

/**
 * @author liu.zongbin
 * @since 2022/8/16 22:22
 */
public class Phone {

    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("电压为5V，可以充电");
        } else if (iVoltage5V.output5V() > 5){
            System.out.println("电压大于5V，不能充电");
        }
    }
}
