package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * @author liu.zongbin
 * @since 2022/10/27
 */
public class Question283 {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        Question283 question1822 = new Question283();
        int[] nums = {1, 2, 0, 0, 12};
        question1822.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
