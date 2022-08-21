package com.hermes.designpattern.template.hook;

/**
 * @author liu.zongbin
 * @since 2022/8/21 14:45
 */
public class PureSoyaMilk extends SoyaMilk {

    @Override
    void addCondiments() {
        // 不添加配料
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
