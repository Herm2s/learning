package com.hermes.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liu.zongbin
 * @since 2022/8/20 21:53
 */
public class ProxyFactory {

    /**
     * 维护一个目标对象
     */
    private Object target;

    public ProxyFactory(Object object) {
        this.target = object;
    }

    /**
     * 生成目标对象的代理对象
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK 动态代理开始...");
                        // 反射调用目标对象的方法
                        Object returnVal = method.invoke(target, args);
                        System.out.println("JDK 动态代理完成...");
                        return returnVal;
                    }
                });
    }
}
