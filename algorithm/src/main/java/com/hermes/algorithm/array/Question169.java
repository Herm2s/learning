package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * @author liu.zongbin
 * @since 2022/10/27
 */
public class Question169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        Question169 question169 = new Question169();
        System.out.println(question169.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
