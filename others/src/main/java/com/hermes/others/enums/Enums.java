package com.hermes.others.enums;

import java.util.Random;

/**
 * @author liu.zongbin
 * @since 2022/11/28
 */
public class Enums {

    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}
