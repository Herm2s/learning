package com.hermes.designpattern.adapter.object;

import com.hermes.designpattern.adapter.IVoltage5V;
import com.hermes.designpattern.adapter.Voltage220V;

/**
 * @author liu.zongbin
 * @since 2022/8/16 22:45
 */
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        // 获取到220V电压
        int srcV = voltage220V.output220V();
        System.out.println("使用对象适配器模式进行适配");
        // 转化成5V
        int dstV = srcV / 44;
        System.out.println("适配完成，输出的电压=" + dstV + "V");
        return dstV;
    }
}
