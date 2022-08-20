package com.hermes.designpattern.proxy.cglib;

/**
 * @author liu.zongbin
 * @since 2022/8/20 22:21
 */
public class Client {

    public static void main(String[] args) {
        // 创建目标对象
        TeacherDao target = new TeacherDao();
        // 创建代理对象
        TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(target).getProxyInstance();
        // 执行代理对象的方法，触发intercept方法，从而实现代理
        String result = proxyInstance.teach();
        System.out.println("result = " + result);
    }
}
