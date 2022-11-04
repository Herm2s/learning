package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * 颜色分类
 *
 * @author liu.zongbin
 * @since 2022/11/4
 */
public class Question75 {

    /**
     * 经典双循环
     */
    public void sortColors(int[] nums) {
        for (int n = 0; n < nums.length; n++) {
            int i = 0;
            int j = 1;
            while (j < nums.length) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                i++;
                j++;
            }
        }
    }

    /**
     * 双指针
     */
    public void sortColors1(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
//            int[] temp = Arrays.copyOf(nums, nums.length);
            int num = nums[i];
            // 先都设定成2
            nums[i] = 2;
            if (num < 2) {
                // 如果有小于2的，说明之前的应该设置成1
                nums[p1++] = 1;
            }
            if (num < 1) {
                // 如果有小于1的，说明之前的应该设置成0
                nums[p0++] = 0;
            }
//            System.out.println(Arrays.toString(temp) + " --> " + Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        Question75 question75 = new Question75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        question75.sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
