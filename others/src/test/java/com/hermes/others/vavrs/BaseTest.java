package com.hermes.others.vavrs;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

/**
 * @author liu.zongbin
 * @since 2022/8/8
 */
class BaseTest {


    @Test
    void tryTest() {
        Integer dividend = 1;
        Integer divisor = 0;
        Try<Integer> result = Try.of(() -> dividend / divisor);
        result.isSuccess();
        System.out.println(result.isSuccess());


    }

    @Test
    void collectionTest() {
        List<Integer> list1 = List.of(1, 2, 3);
        System.out.println(list1);

        List<Integer> list2 = list1.prepend(0);
        System.out.println(list1);
        System.out.println(list2);
    }

    @Test
    void functionTest() {
        // 常规使用：( a+b ) * 2
        Function2<Integer, Integer, Integer> plus = Integer::sum;
        Function1<Integer, Integer> multiply = a -> a * 2;

        Function2<Integer, Integer, Integer> addAndMultiply = plus.andThen(multiply);
        System.out.println(addAndMultiply.apply(1, 2));

        // lift
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        Option<Integer> i1 = safeDivide.apply(1, 0);

        List.of(1, 2, 3).sum();
    }

}
