package com.hermes.algorithm.dp;

/**
 * @author liu.zongbin
 * @since 2022/11/21
 */
public class Question123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]：第i天没有操作
        // dp[i][1]：第i天还是第一次买入的状态
        // dp[i][2]：第i天还是第一次卖出的状态
        // dp[i][3]：第i天还是第二次买入的状态
        // dp[i][4]：第i天还是第二次卖出的状态
        int[][] dp = new int[n][5];
        // 初始化dp数组
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return dp[n - 1][4];
    }

    public static void main(String[] args) {
        Question123 question123 = new Question123();
        System.out.println(question123.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
