package com.hermes.algorithm.dp;

/**
 * 打家劫舍
 *
 * @author liu.zongbin
 * @since 2022/11/22
 */
public class Question198 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // dp[i]表示0-i的屋子最多能打劫到的钱
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // dp[i]=今天打劫和不打劫中的较大收益
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Question198 question198 = new Question198();
        System.out.println(question198.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
