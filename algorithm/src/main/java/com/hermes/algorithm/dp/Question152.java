package com.hermes.algorithm.dp;

/**
 * 乘积最大子数组
 *
 * @author liu.zongbin
 * @since 2022/11/10
 */
public class Question152 {

    public int maxProduct(int[] nums) {
        int maxF = nums[0];
        int minF = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 当前的最大值
            int mx = maxF;
            // 当前的最小值，可能为负数
            int mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            result = Math.max(maxF, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Question152 question152 = new Question152();
        System.out.println(question152.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
