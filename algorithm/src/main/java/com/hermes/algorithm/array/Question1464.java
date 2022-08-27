package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * 数组中两元素的最大乘积
 *
 * @author liu.zongbin
 * @since 2022/8/26
 */
public class Question1464 {

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2};
        System.out.println(maxProduct(nums));
    }
}
