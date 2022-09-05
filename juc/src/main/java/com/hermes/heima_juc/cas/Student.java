package com.hermes.heima_juc.cas;

import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author liu.zongbin
 * @since 2022/9/5 22:19
 */
@Data
public class Student {
    volatile int id;
    volatile String name;

    public static void main(String[] args) throws NoSuchFieldException {
        Unsafe unsafe = UnsafeAccessor.getUnsafe();
        Field idField = Student.class.getDeclaredField("id");
        Field nameField = Student.class.getDeclaredField("name");
        // 获得成员变量的偏移量
        long idOffset = unsafe.objectFieldOffset(idField);
        long nameOffset = unsafe.objectFieldOffset(nameField);

        Student student = new Student();
        // 使用CAS方法替换成员变量的值
        unsafe.compareAndSwapInt(student, idOffset, 0, 20);
        unsafe.compareAndSwapObject(student, nameOffset, null, "张三");

        System.out.println(student);
    }
}
