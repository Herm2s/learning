package com.hermes.designpattern.adapter.cls;

import com.hermes.designpattern.adapter.IVoltage5V;
import com.hermes.designpattern.adapter.Voltage220V;

/**
 * @author liu.zongbin
 * @since 2022/8/16 22:26
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

    @Override
    public int output5V() {
        // 获取到220V电压
        int srcV = super.output220V();
        // 转化成5V
        int dstV = srcV / 44;
        return dstV;
    }
}
