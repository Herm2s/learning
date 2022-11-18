package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * 存在重复元素
 *
 * @author liu.zongbin
 * @since 2022/11/18
 */
public class Question217 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Question217 question217 = new Question217();
        System.out.println(question217.containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}
