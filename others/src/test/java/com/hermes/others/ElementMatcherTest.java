package com.hermes.others;

import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.StringMatcher;
import org.junit.jupiter.api.Test;

/**
 * @author liu.zongbin
 * @since 2022/9/16
 */
class ElementMatcherTest {

    @Test
    void test1() {
        System.out.println(new StringMatcher("va", StringMatcher.Mode.CONTAINS)
                .matches("value2"));
    }

    public static ElementMatcher.Junction<String> containsA() {
        return new StringMatcher("a", StringMatcher.Mode.CONTAINS);
    }

    public static ElementMatcher.Junction<String> containsB() {
        return new StringMatcher("b", StringMatcher.Mode.CONTAINS);
    }

    public static void main(String[] args) {
        ElementMatcher.Junction<Object> objectJunction = ElementMatchers.anyOf("");
        System.out.println(containsA()
                .and(containsB())
                .matches("ab"));
    }
}
