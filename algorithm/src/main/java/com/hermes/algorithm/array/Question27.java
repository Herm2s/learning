package com.hermes.algorithm.array;

/**
 * @author liu.zongbin
 * @since 2022/8/25 22:45
 */
public class Question27 {

    public  static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
