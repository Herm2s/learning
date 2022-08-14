package com.hermes.algorithm.array;

/**
 * 二分查找
 * leetcode题号704
 *
 * @author liu.zongbin
 * @since 2022/8/11 22:50
 */
public class BinarySearch {

    /**
     * 左闭右闭写法
     * [left, right]
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // [left, right]，left存在=right的情况
        while (left <= right) {
            int middle = (left + right) / 2;
            // middle位置的值大于target，移动right
            if (nums[middle] > target) {
                // array[middle] 都小于 target了，因此下一个区间不需要包含middle，要-1
                right = middle - 1;
            }
            // middle位置的值小于target，移动left
            else if (nums[middle] < target) {
                // array[middle] 都大于 target了，因此下一个区间不需要包含middle，要+1
                left = middle + 1;
            } else {
                // middle位置的值等于target，直接返回
                return middle;
            }
        }
        return -1;
    }

    /**
     * 左闭右开写法
     * [left, right)
     */
    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // [left, right)，left不存在=right的情况
        while (left < right) {
            int middle = (left + right) / 2;
            // middle位置的值大于target，移动right
            if (nums[middle] > target) {
                // array[middle] 都小于 target了，因此下一个区间不需要包含middle，因为这里是右开，不需要-1
                right = middle;
            }
            // middle位置的值小于target，移动left
            else if (nums[middle] < target) {
                // array[middle] 都大于 target了，因此下一个区间不需要包含middle，要+1
                left = middle + 1;
            } else {
                // middle位置的值等于target，直接返回
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,7,8};
        System.out.println(search1(nums, 8));
    }
}
