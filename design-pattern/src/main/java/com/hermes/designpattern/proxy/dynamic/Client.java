package com.hermes.designpattern.proxy.dynamic;


/**
 * @author liu.zongbin
 * @since 2022/8/20 21:51
 */
public class Client {

    public static void main(String[] args) {
        // 创建目标对象
        ITeacherDao target = new TeacherDao();
        // 创建目标对象的代理对象
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("proxyInstance = " + proxyInstance.getClass());

        // 通过代理对象调用目标对象的方法
        proxyInstance.teach();
        proxyInstance.sayHello("tom");
    }
}
