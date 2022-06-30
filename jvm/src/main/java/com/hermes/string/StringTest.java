package com.hermes.string;

import org.junit.Test;


/**
 * @author liu.zongbin
 * @created 2022/6/28 11:47
 */
public class StringTest {

    @Test
    public void test1() {
        String s1 = "abc"; // 字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1 == s2);

        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test2() {
        new String("abc");
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
    }

    @Test
    public void test3() {
        String s1 = new String("1");
        String s2 = "1";
        System.out.println(s1 == s2);
    }

    @Test
    public void test4() {
        String s1 = new StringBuilder("mei").append("tuan").toString();
        System.out.println(s1);
        System.out.println(s1.intern());
        System.out.println(s1 == s1.intern());

        System.out.println();
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2);
        System.out.println(s2.intern());
        System.out.println(s2 == s2.intern());
    }
}

