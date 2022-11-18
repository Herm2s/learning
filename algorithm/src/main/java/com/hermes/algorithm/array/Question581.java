package com.hermes.algorithm.array;

/**
 * 最短无序连续子数组
 *
 * @author liu.zongbin
 * @since 2022/11/18
 */
public class Question581 {

    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int right = -1;
        int length = nums.length;
        // 右区间的最小值
        int min = Integer.MAX_VALUE;
        // 左区间的最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            // 从左往右找比左区间的最大值还小的最右下标
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
            // 从右往左找比右区间的最小值还大的最左下标
            if (nums[length - i - 1] > min) {
                left = length - i - 1;
            } else {
                min = nums[length - i - 1];
            }
        }
        // 左右下标就是要求的区间
        return right == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        Question581 question581 = new Question581();
        System.out.println(question581.findUnsortedSubarray(new int[]{1, 2, 6, 4, 8, 10, 9, 15, 17}));
    }
}
