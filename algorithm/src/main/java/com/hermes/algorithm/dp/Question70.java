package com.hermes.algorithm.dp;

/**
 * 爬楼梯
 *
 * @author liu.zongbin
 * @since 2022/10/26
 */
public class Question70 {

    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question70 question70 = new Question70();
        System.out.println(question70.climbStairs(3));
    }
}
