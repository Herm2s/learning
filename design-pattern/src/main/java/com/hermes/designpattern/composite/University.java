package com.hermes.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 学校——Composite：非叶子节点
 *
 * @author liu.zongbin
 * @since 2022/8/19 22:21
 */
public class University extends OrganizationComponent {

    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        this.organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        this.organizationComponents.remove(organizationComponent);
    }

    /**
     * 输出University包含的学院
     */
    @Override
    protected void print() {
        System.out.println("--------------" + super.getName() + "--------------");

        for (OrganizationComponent organizationComponent : this.organizationComponents) {
            organizationComponent.print();
        }
    }
}
