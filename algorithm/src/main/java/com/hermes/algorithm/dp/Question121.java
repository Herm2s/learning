package com.hermes.algorithm.dp;

/**
 * 买卖股票的最佳时机
 *
 * @author liu.zongbin
 * @since 2022/10/26
 */
public class Question121 {

    /**
     * 贪心算法
     */
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        // res不断更新，直到数组循环完毕
        int result = 0;
        for (int price : prices) {
            // 找到一个最小的购入点
            low = Math.min(price, low);
            result = Math.max(result, price - low);
            System.out.println();
        }
        return result;
    }

    /**
     * 动态规划
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        // 0表示未持有股票
        // 1表示持有股票
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 昨天不持有股票，保持现状：dp[0]
            // 昨天持有股票，今天卖出：dp[1] + prices[i]
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            // 昨天不持有股票，今天买入：- prices[i]
            // 昨天持有股票，保持现状：dp[1]
            dp[1] = Math.max(-prices[i], dp[1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Question121 question121 = new Question121();
        System.out.println(question121.maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
