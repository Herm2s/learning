package com.hermes.designpattern.iterator;

import java.util.Iterator;

/**
 * @author liu.zongbin
 * @since 2022/8/23 21:46
 */
public class ComputerCollegeIterator implements Iterator<Department> {

    Department[] departments;

    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return position < departments.length
                && departments[position] != null;
    }

    @Override
    public Department next() {
        Department department = departments[position];
        position++;
        return department;
    }
}
