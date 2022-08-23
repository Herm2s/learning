package com.hermes.designpattern.iterator;

import java.util.Iterator;

/**
 * @author liu.zongbin
 * @since 2022/8/23 21:41
 */
public interface College {

    String getName();

    void addDepartment(String name, String desc);

    Iterator<Department> createIterator();
}
