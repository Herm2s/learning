package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * @author liu.zongbin
 * @since 2022/11/1
 */
public class Question31 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到第一个低位比高位大的位置，进行交换
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 找到尽可能小的低位进行交换
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // start之后所有数字，保证是最小的
        reverse(nums, i + 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Question31 question31 = new Question31();
        int[] nums = {4, 5, 2, 6, 3, 1};
        question31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
