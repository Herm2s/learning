package com.hermes.algorithm;

/**
 * @author liu.zongbin
 * @since 2022/8/12
 */
public class BinarySearch {

    /**
     * 左闭右开
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 左闭右闭
     */
    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 9));
        System.out.println(search1(nums, 2));
    }
}
