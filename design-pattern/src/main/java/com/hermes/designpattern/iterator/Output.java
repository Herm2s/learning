package com.hermes.designpattern.iterator;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/8/23 21:55
 */
@AllArgsConstructor
public class Output {

    List<College> collegeList;

    public void printCollege() {
        for (College college : collegeList) {
            System.out.println("=====" + college.getName() + "=====");
            this.printDepartment(college.createIterator());
        }
    }

    private void printDepartment(Iterator<Department> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
