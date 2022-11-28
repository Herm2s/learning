package com.hermes.others.generictype;

/**
 * @author liu.zongbin
 * @since 2022/11/22
 */
abstract class GenericWithCreate<T> {

    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {
}

class Creator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {

    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.f();
    }
}
