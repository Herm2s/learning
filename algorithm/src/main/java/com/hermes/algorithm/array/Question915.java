package com.hermes.algorithm.array;

/**
 * 分割数组
 *
 * @author liu.zongbin
 * @since 2022/10/24
 */
public class Question915 {

    public int partitionDisjoint(int[] nums) {
        // 左边数组的最大值
        int leftMax = nums[0];
        // 分割点
        int leftPos = 0;
        // 遍历过程中的最大值
        int curMax = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }

    public static void main(String[] args) {
        Question915 question915 = new Question915();
        System.out.println(question915.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
    }
}
