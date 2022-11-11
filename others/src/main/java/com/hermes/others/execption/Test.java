package com.hermes.others.execption;

/**
 * @author liu.zongbin
 * @since 2022/11/10
 */
public class Test {

    public void test1() {
        throw new ClassCastException("test1");
    }

    public void test2() {
        try {
            test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
//        test.test2();
        boolean instance = Test.class.isInstance(test);
        System.out.println(instance);
    }

    @Override
    public String toString() {
        return " address = " + super.toString();
    }
}
