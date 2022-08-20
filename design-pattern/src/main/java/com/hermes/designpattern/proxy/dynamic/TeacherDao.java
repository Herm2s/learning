package com.hermes.designpattern.proxy.dynamic;

/**
 * @author liu.zongbin
 * @since 2022/8/20 21:58
 */
public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("老师讲课中...");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello, " + name);
    }
}
