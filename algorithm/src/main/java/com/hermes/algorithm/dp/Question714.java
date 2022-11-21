package com.hermes.algorithm.dp;

/**
 * 买卖股票的最佳时机含手续费
 *
 * @author liu.zongbin
 * @since 2022/11/21
 */
public class Question714 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // dp[i][0]表示第i天不持有股票
        // dp[i][1]表示第i天持有股票
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 卖出时支付手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        Question714 question714 = new Question714();
        System.out.println(question714.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
