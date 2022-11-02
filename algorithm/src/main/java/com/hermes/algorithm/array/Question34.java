package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author liu.zongbin
 * @since 2022/11/1
 */
public class Question34 {

    /**
     * 5, 7, 7, 8, 8, 10
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        // 查找第一个>=target的位置
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[right] != target) {
            return new int[]{-1, -1};
        }
        int leftIndex = right;
        left = 0;
        right = nums.length - 1;
        // 查找最后一个<=target的位置
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{leftIndex, right};
    }

    public static void main(String[] args) {
        Question34 question34 = new Question34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(question34.searchRange(nums, target)));
    }
}
