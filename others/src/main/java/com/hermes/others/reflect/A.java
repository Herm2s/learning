package com.hermes.others.reflect;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/11/16
 */
public class A {

    private class C {

    }

    public C test() {
        return new C();
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        TypeVariable<? extends Class<? extends List>>[] typeParameters = a.getClass().getTypeParameters();
        System.out.println(typeParameters);
    }
}
