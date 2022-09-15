package com.hermes.others.reflect;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liu.zongbin
 * @since 2022/9/15
 */
class ReflectionTest {

    @Test
    void test1() throws Exception {
        Class<Person> clazz = Person.class;
        // 1. 通过反射，创建Person类对象
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("Tom", 12);
        System.out.println(person);

        // 2. 通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(person, 10);
        System.out.println(person);
        // 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        System.out.println("==================================");
        // 通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        // 调用私有的构造器
        Constructor<Person> constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person person1 = constructor1.newInstance("Bruce");
        System.out.println(person1);

        // 调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "Jack");
        System.out.println(person1);

        // 调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object china = showNation.invoke(person1, "China");
        System.out.println(china);
    }

    @Test
    void test2() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> clazz3 = Class.forName("com.hermes.others.reflect.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.hermes.others.reflect.Person");
        System.out.println(clazz4);//class cn.bruce.java.Person
        System.out.println(clazz1 == clazz4);//true
    }


    @Test
    void test3() {
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] i1 = new int[10];
        int[] i2 = new int[100];
        Class<? extends int[]> c10 = i1.getClass();
        Class<? extends int[]> c11 = i2.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);//true
    }
}
