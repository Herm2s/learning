package com.hermes.others.reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/11/18
 */
public class FilledListMaker<T> {

    List<T> create(T t, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }
}
