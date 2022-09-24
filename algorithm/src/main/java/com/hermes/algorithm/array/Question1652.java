package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * @author herm2s
 * @since 2022/9/24 13:26
 */
public class Question1652 {

    public static void main(String[] args) {
        Question1652 question1652 = new Question1652();
        System.out.println(Arrays.toString(question1652.decrypt(new int[]{5, 7, 1, 4, 3}, -4)));
    }

    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];
        if (k == 0) {
            return result;
        }
        // 确定滑动窗口左边和右边
        int left = k > 0 ? 1 : length + k;
        int right = k > 0 ? k : length - 1;
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += code[i];
        }
        for (int i = 0; i < length; i++) {
            result[i] = sum;
            sum -= code[left];
            // 移动滑动窗口
            left = (left + 1) % length;
            right = (right + 1) % length;
            sum += code[right];
        }
        return result;
    }
}
