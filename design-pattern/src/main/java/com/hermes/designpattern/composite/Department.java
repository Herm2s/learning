package com.hermes.designpattern.composite;

/**
 * 专业——Leaf：叶子节点
 *
 * @author liu.zongbin
 * @since 2022/8/19 22:24
 */
public class Department extends OrganizationComponent {

    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void print() {
        System.out.println(super.getName());
    }
}
