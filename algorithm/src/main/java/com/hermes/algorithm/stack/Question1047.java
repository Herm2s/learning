package com.hermes.algorithm.stack;

import java.util.Stack;

/**
 * @author liu.zongbin
 * @since 2022/9/3 12:30
 */
public class Question1047 {

    public static String removeDuplicates(String s) {
        if (s.length() == 1) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character peek = stack.peek();
                if (peek == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        char[] result = new char[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            result[j] = stack.pop();
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
