package com.hermes.classloader;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/16
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);
        // 试图获取其上层：bootstrap class loader:获取不到引导类加载器
        ClassLoader parent = extClassLoader.getParent();
        System.out.println(parent);

        // 获取用户自定义类的加载器：默认使用系统类加载器加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        // String类是使用引导类加载器进行加载的---》Java的核心类库都是用引导类加载器进行加载的
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);
    }
}
