package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * @author liu.zongbin
 * @since 2022/10/28
 */
public class Question338 {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Question338 question338 = new Question338();
        System.out.println(Arrays.toString(question338.countBits(3)));
    }
}
