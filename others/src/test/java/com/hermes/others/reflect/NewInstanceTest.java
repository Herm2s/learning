package com.hermes.others.reflect;

import org.junit.jupiter.api.Test;

/**
 * @author liu.zongbin
 * @since 2022/9/15
 */
class NewInstanceTest {

    @Test
    void test1() throws Exception {
        //方式一
        Class<Person> clazz1 = Person.class;
        //方式二
        Class<Person> clazz2 = (Class<Person>) Class.forName("com.hermes.others.reflect.Person");

        Person person1 = clazz1.newInstance();
        Person person2 = clazz2.newInstance();
        System.out.println(person1);
        System.out.println(person2);
    }
}
