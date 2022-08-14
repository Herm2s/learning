package com.hermes.algorithm.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组排序
 *
 * @author liu.zongbin
 * @since 2022/8/14 13:11
 */
public class Question912 {

    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int point = partition(nums, left, right);
        quickSort(nums, left, point - 1);
        quickSort(nums, point + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int i = left;
        // 随机挑选一个幸运儿
        int q = new Random().nextInt(right - left + 1) + left;
        swap(nums, right, q);

        for (int j = left; j < right; ++j) {
            if (nums[j] < nums[right]) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i += 1;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(sortArray(nums)));
    }
}
