package com.hermes.heima_juc.cas;

import lombok.Setter;

/**
 * @author liu.zongbin
 * @since 2022/9/4 22:14
 */
public class GarbageBag {

    @Setter
    String desc;

    public GarbageBag(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return super.toString() + " " + desc;
    }
}
