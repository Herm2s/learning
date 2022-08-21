package com.hermes.designpattern.template.hook;


/**
 * @author liu.zongbin
 * @since 2022/8/21 14:17
 */
public class RedBeanSoyaMilk extends SoyaMilk {

    @Override
    void addCondiments() {
        System.out.println("第二步：加入上好的红豆");
    }
}
