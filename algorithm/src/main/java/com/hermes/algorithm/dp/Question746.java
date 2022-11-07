package com.hermes.algorithm.dp;

/**
 * 使用最小花费爬楼梯
 *
 * @author herm2s
 * @since 2022/11/7 20:56
 */
public class Question746 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        Question746 question746 = new Question746();
        System.out.println(question746.minCostClimbingStairs(new int[]{2, 2, 1, 0}));
    }
}
