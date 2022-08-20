package com.hermes.designpattern.proxy.staticproxy;

/**
 * @author liu.zongbin
 * @since 2022/8/20 21:27
 */
public class Client {

    public static void main(String[] args) {
        // 目标对象（被代理对象）
        TeacherDao teacherDao = new TeacherDao();

        TeacherDaoProxy proxy = new TeacherDaoProxy(teacherDao);
        // 通过代理对象调用到被代理对象的方法
        proxy.teach();
    }
}
