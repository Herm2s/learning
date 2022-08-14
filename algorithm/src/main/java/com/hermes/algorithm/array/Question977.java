package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * 977
 *
 * @author liu.zongbin
 * @since 2022/8/13 12:45
 */
public class Question977 {

    /**
     * 双指针
     * i指针从头探测
     * j指针从尾探测
     * 谁大谁移动指针
     */
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            int i2 = nums[i] * nums[i];
            int j2 = nums[j] * nums[j];
            if (i2 >= j2) {
                result[k] = i2;
                i++;
            } else {
                result[k] = j2;
                j--;
            }
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
