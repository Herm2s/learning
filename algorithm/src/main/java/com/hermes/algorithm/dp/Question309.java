package com.hermes.algorithm.dp;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * @author liu.zongbin
 * @since 2022/11/21
 */
public class Question309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]：今天买入股票或者之前就买入了，今天没有操作
        // dp[i][1]：两天前就卖出股票（渡过了冷冻期），今天没操作，保持卖出状态
        // dp[i][2]：今天卖出股票
        // dp[i][3]：今天是冷冻期
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][1], Math.max(dp[n - 1][2], dp[n - 1][3]));
    }

    public static void main(String[] args) {
        Question309 question309 = new Question309();
        System.out.println(question309.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
