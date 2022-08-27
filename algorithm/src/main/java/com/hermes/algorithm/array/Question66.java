package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * 加一
 * 2 8 9 9
 *
 * @author liu.zongbin
 * @since 2022/8/26
 */
public class Question66 {

    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
    }
}
