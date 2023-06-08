package com.hermes.others.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 获取运行时泛型
 *
 * @author liu.zongbin
 * @since 2023/6/8
 */
public class GenericRuntimeTypeTest {

    static class Wrapper<T> {

    }

    public static <T> Type getGenericRuntimeType(Wrapper<T> wrapper) {
        Type type = wrapper.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }

        if (type instanceof ParameterizedType parameterizedType) {
            Type[] types = parameterizedType.getActualTypeArguments();
            return types[0];
        }
        return null;
    }

    public static void main(String[] args) throws ReflectiveOperationException{
        Type runtimeType = getGenericRuntimeType(new Wrapper<List<String>>(){});
        System.out.println(runtimeType);
    }
}
