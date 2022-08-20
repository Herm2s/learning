package com.hermes.designpattern.proxy.cglib;

/**
 * @author liu.zongbin
 * @since 2022/8/20 22:27
 */
public class TeacherDao {

    public String teach() {
        System.out.println("老师讲课中，我是Cglib代理，不需要实现接口~");
        return "hello";
    }
}
