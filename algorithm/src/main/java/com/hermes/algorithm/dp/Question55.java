package com.hermes.algorithm.dp;

/**
 * 跳跃游戏
 *
 * @author liu.zongbin
 * @since 2022/11/3
 */
public class Question55 {

    /**
     * 贪心
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxPosition = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxPosition) {
                // 维护每次遍历可以达到的最大距离
                maxPosition = Math.max(maxPosition, i + nums[i]);
                System.out.println(maxPosition);
                if (maxPosition >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 动态规划
     */
    public boolean canJump1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int n = nums.length;
        // dp[i]含义：从这个下标出发能到达的最远距离
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 不需要考虑最后一个下标
        for (int i = 1; i < n - 1; i++) {
            // dp[i]推导：dp[i] = max(dp[i-1] , i+nums[i])
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            if (dp[i] == i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question55 question55 = new Question55();
        System.out.println(question55.canJump1(new int[]{1, 2}));
    }
}
