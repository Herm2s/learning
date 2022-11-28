package com.hermes.others.generictype;

/**
 * @author liu.zongbin
 * @since 2022/11/22
 */
interface FactoryI<T> {
    T create();
}

class ObjectHolder<T> {
    private T x;

    public <F extends FactoryI<T>> ObjectHolder(F factory) {
        x = factory.create();
    }

    public T getX() {
        return x;
    }
}

class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create() {
        return 0;
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstraint {

    public static void main(String[] args) {
        ObjectHolder<Integer> a = new ObjectHolder<>(new IntegerFactory());
        System.out.println(a.getX());

        ObjectHolder<Widget> b = new ObjectHolder<>(new Widget.Factory());
        System.out.println(b.getX());
    }
}
