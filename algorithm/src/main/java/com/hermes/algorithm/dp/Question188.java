package com.hermes.algorithm.dp;

/**
 * 买卖股票的最佳时机4
 *
 * @author liu.zongbin
 * @since 2022/11/21
 */
public class Question188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // dp[i][j]：第i天的状态，j为奇数表示第j次买入，偶数表示第j次卖出，0表示不操作
        int[][] dp = new int[n][k * 2 + 1];
        // 初始化dp数组
        for (int i = 1; i < k * 2; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k * 2 - 1; j += 2) {
                // 奇数
                dp[i][j + 1] = Math.max(dp[i - 1][j] - prices[i], dp[i - 1][j + 1]);
                // 偶数
                dp[i][j + 2] = Math.max(dp[i - 1][j + 1] + prices[i], dp[i - 1][j + 2]);
            }
        }
        return dp[n - 1][k * 2];
    }

    public static void main(String[] args) {
        Question188 question188 = new Question188();
        System.out.println(question188.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
