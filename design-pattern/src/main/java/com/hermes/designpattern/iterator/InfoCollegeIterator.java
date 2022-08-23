package com.hermes.designpattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/8/23 21:46
 */
public class InfoCollegeIterator implements Iterator<Department> {

    List<Department> departmentList;

    int index = -1;

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() - 1) {
            return false;
        } else {
            index++;
            return true;
        }
    }

    @Override
    public Department next() {
        return departmentList.get(index);
    }
}
