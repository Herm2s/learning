package com.hermes.others.generictype;

/**
 * 实例化泛型
 *
 * @author liu.zongbin
 * @since 2022/11/22
 */
class ClassAsFactory<T> {

    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {

}

public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> factory = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> factory1 = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}
