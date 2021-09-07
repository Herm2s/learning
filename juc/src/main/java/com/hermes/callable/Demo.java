package com.hermes.callable;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/6
 */
public class Demo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);
        List<Integer> list1 = Collections.unmodifiableList(list);
        ImmutableList<Integer> list2 = ImmutableList.copyOf(list);
        System.out.println(list1);
        list.add(2);
        System.out.println(list1);
        System.out.println(list2);
    }
}
