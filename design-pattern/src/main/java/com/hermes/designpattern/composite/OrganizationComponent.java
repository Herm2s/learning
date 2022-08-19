package com.hermes.designpattern.composite;

import lombok.Data;

/**
 * @author liu.zongbin
 * @since 2022/8/19 22:19
 */
@Data
public abstract class OrganizationComponent {

    /**
     * 名字
     */
    private String name;

    /**
     * 说明
     */
    private String desc;

    public OrganizationComponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    protected void add(OrganizationComponent organizationComponent) {
        // 默认实现
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent) {
        // 默认实现
        throw new UnsupportedOperationException();
    }

    /**
     * print做成抽象的，子类需要实现
     */
    protected abstract void print();
}
