package com.hermes.designpattern.iterator;

import java.util.Iterator;

/**
 * @author liu.zongbin
 * @since 2022/8/23 21:42
 */
public class ComputerCollege implements College {

    Department[] departments;

    int num = 0;

    public ComputerCollege() {
        this.departments = new Department[5];
        addDepartment("Java专业", "Java专业");
        addDepartment("PHP专业", "PHP专业");
        addDepartment("大数据专业", "大数据专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        this.departments[num] = department;
        num++;
    }

    @Override
    public Iterator<Department> createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
