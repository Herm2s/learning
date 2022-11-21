package com.hermes.algorithm.dp;

/**
 * 最佳买卖股票时机2
 *
 * @author liu.zongbin
 * @since 2022/11/21
 */
public class Question122 {

    /**
     * 动态规划
     */
    public int maxProfit(int[] prices) {
        // dp[i][0]表示第i天不持有股票的收入
        // dp[i][1]表示第i天持有股票的收入
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 昨天不持有股票，保持现状：dp[i-1][0]
            // 昨天持有股票，今天卖出：dp[i-1][1] + prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 昨天不持有股票，今天买入：dp[i-1][0] - prices[i]
            // 昨天持有股票，保持现状：dp[i-1][1]
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    /**
     * 动态规划—优化空间
     */
    public int maxProfit1(int[] prices) {
        int[] dp = new int[2];
        // 0表示未持有，1表示持有
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 昨天不持有股票，保持现状：dp[0]
            // 昨天持有股票，今天卖出：dp[1] + prices[i]
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            // 昨天不持有股票，今天买入：dp[0] - prices[i]
            // 昨天持有股票，保持现状：dp[1]
            dp[1] = Math.max(dp[0] - prices[i], dp[1]);
        }
        return dp[0];
    }

    /**
     * 贪心算法
     */
    public int maxProfit2(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }

    public static void main(String[] args) {
        Question122 question122 = new Question122();
        System.out.println(question122.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
