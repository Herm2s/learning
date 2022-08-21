package com.hermes.designpattern.template.hook;

/**
 * 豆浆
 *
 * @author liu.zongbin
 * @since 2022/8/21 14:11
 */
public abstract class SoyaMilk {

    /**
     * 模板方法make，不允许子类覆盖
     */
    final void make() {
        this.select();
        if (customerWantCondiments()) {
            this.addCondiments();
        }
        this.soak();
        this.beat();
    }

    /**
     * 选材
     */
    void select() {
        System.out.println("第一步：选择好的新鲜豆浆");
    }

    /**
     * 添加不同配料，由子类实现
     */
    abstract void addCondiments();

    /**
     * 浸泡
     */
    void soak() {
        System.out.println("第三步：豆子和配料开始浸泡，需要3小时");
    }

    /**
     * 打碎
     */
    void beat() {
        System.out.println("第四步：放到豆浆机打碎");
    }

    /**
     * 钩子方法，决定是否添加配料
     */
    boolean customerWantCondiments() {
        return true;
    }
}
