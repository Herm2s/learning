package com.hermes.algorithm.dp;

/**
 * 最大子数组和
 *
 * @author liu.zongbin
 * @since 2022/11/3
 */
public class Question53 {

    /**
     * 贪心算法
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    /**
     * 动态规划
     */
    public int maxSubArray1(int[] nums) {
        int result = nums[0];
        // dp[i]含义：包含num[i]的之前的最大连续子序列和
        // dp[i]推导：dp[i - 1] + nums[i] 和 nums[i]之间的较大者
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            dp[i] = Math.max(dp[i - 1] + num, num);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Question53 question53 = new Question53();
        System.out.println(question53.maxSubArray1(new int[]{-1, -2}));
    }
}
