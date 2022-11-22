package com.hermes.algorithm.dp;

/**
 * 打家劫舍2
 *
 * @author liu.zongbin
 * @since 2022/11/22
 */
public class Question213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 考虑第一栋，排除最后一栋
        int first = max(nums, 0, nums.length - 2);
        // 考虑最后一栋，排除第一栋
        int end = max(nums, 1, nums.length - 1);
        return Math.max(first, end);
    }

    private int max(int[] nums, int start, int end) {
        // dp[i]表示0-i的屋子最多能打劫到的钱
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            // dp[i]=今天打劫和不打劫中的较大收益
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }

    public static void main(String[] args) {
        Question213 question213 = new Question213();
        System.out.println(question213.rob(new int[]{1, 2, 3, 1}));
    }
}
