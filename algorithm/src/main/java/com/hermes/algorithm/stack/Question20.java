package com.hermes.algorithm.stack;


import java.util.Stack;

/**
 * @author liu.zongbin
 * @since 2022/9/3 12:07
 */
public class Question20 {

    public static boolean isValid(String s) {
        if (s.length() % 2 > 0) {
            return false;
        }
        char ll = '(';
        char rl = ')';
        char lm = '[';
        char rm = ']';
        char lb = '{';
        char rb = '}';
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ll) {
                stack.push(rl);
            }
            if (c == lm) {
                stack.push(rm);
            }
            if (c == lb) {
                stack.push(rb);
            }

            if (c == rl || c == rm || c == rb) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != c) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
