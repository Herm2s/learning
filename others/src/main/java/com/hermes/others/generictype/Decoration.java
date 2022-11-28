package com.hermes.others.generictype;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liu.zongbin
 * @since 2022/11/22
 */
class Basic {
    @Getter
    @Setter
    private String value;

}

class Decorator extends Basic {
    @Getter
    @Setter
    protected Basic basic;

    public Decorator(Basic basic) {
        this.basic = basic;
    }
}

class TimeStamped extends Decorator {

    private final long timeStamp;

    public TimeStamped(Basic basic) {
        super(basic);
        this.timeStamp = System.currentTimeMillis();
    }
}

class SerialNumbered extends Decorator {
    private static long counter = 1;
    @Getter
    private final long serialNumber = counter++;

    public SerialNumbered(Basic basic) {
        super(basic);
    }
}

public class Decoration {

    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic());
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
    }
}
