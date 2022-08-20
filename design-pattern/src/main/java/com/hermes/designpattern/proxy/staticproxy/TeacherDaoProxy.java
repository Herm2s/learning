package com.hermes.designpattern.proxy.staticproxy;

/**
 * @author liu.zongbin
 * @since 2022/8/20 21:30
 */
public class TeacherDaoProxy implements ITeacherDao {

    /**
     * 被代理对象
     */
    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理...");
        this.target.teach();
        System.out.println("代理完成...");
    }
}
