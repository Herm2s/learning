package com.hermes.others.util;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author herm2s
 * @since 2023/2/11 21:29
 */
public interface Converter<T, U> {

    U from(T databaseObject);

    T to(U userObject);

    Class<T> fromType();

    Class<U> toType();

    static <T, U> Converter<T, U> of(Class<T> fromType,
                                     Class<U> toType,
                                     Function<? super T, ? extends U> from,
                                     Function<? super U, ? extends T> to) {
        return new Converter<T, U>() {
            @Override
            public U from(T databaseObject) {
                return from.apply(databaseObject);
            }

            @Override
            public T to(U userObject) {
                return to.apply(userObject);
            }

            @Override
            public Class<T> fromType() {
                return fromType;
            }

            @Override
            public Class<U> toType() {
                return toType;
            }
        };
    }

    static <T, U> Converter<T, U> ofNullable(Class<T> fromType,
                                             Class<U> toType,
                                             Function<? super T, ? extends U> from,
                                             Function<? super U, ? extends T> to) {
        return of(
                fromType,
                toType,
                t -> t == null ? null : from.apply(t),
                t -> t == null ? null : to.apply(t)
        );
    }

    public static void main(String[] args) {
        Converter<String, Integer> converter = Converter.ofNullable(
                String.class,
                Integer.class,
                s -> Integer.parseInt(s, 16),
                Integer::toHexString
        );
        System.out.println(converter.from("1"));

        int[] ints = Stream.of(1, 8, 3, 5, 6, 2, 4, 7)
                .collect(Collector.of(
                        () -> new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE},
                        (a, t) -> {
                            if (a[0] < t) {
                                a[1] = a[0];
                                a[0] = t;
                            } else if (a[1] < t)
                                a[1] = t;
                        },
                        (a1, a2) -> {
                            throw new UnsupportedOperationException(
                                    "Say no to parallel streams");
                        }
                ));
        for (int i : ints)
            System.out.println(i);
    }
}
