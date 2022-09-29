package com.hermes.algorithm.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liu.zongbin
 * @since 2022/9/29
 */
public class Question739 {

    public static void main(String[] args) {
        Question739 question739 = new Question739();
        System.out.println(Arrays.toString(question739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        if (length == 1) {
            return new int[1];
        }
        int[] result = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                Integer preIndex = stack.pop();
                result[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
