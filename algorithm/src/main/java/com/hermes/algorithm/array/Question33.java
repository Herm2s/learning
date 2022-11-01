package com.hermes.algorithm.array;

/**
 * 搜索旋转排序数组
 *
 * @author liu.zongbin
 * @since 2022/11/1
 */
public class Question33 {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左半部分为有序的
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    // 目标在左半部分
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 右半部分为有序的
            else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    // 目标在右半部分
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Question33 question33 = new Question33();
        // 0 1 2 4 5 6 7
        System.out.println(question33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
