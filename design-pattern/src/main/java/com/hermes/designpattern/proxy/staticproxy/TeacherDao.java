package com.hermes.designpattern.proxy.staticproxy;

/**
 * @author liu.zongbin
 * @since 2022/8/20 21:29
 */
public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("老师讲课中...");
    }
}
