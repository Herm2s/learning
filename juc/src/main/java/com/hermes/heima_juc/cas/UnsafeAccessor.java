package com.hermes.heima_juc.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 反射获取UnSafe对象
 *
 * @author liu.zongbin
 * @since 2022/9/5 22:17
 */
public class UnsafeAccessor {

    static Unsafe unsafe;

    static {
        try {
            Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            unsafe = (Unsafe) theUnsafeField.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
    }

    static Unsafe getUnsafe() {
        return unsafe;
    }
}
