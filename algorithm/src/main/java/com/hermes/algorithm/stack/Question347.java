package com.hermes.algorithm.stack;

import java.util.Arrays;

/**
 * @author liu.zongbin
 * @since 2022/9/4 13:04
 */
public class Question347 {

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
