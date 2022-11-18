package com.hermes.algorithm.dp;

/**
 * 整数拆分
 *
 * @author liu.zongbin
 * @since 2022/11/17
 */
public class Question343 {

    public int integerBreak(int n) {
        // dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            // 这里的 j 其实最大值为 i-j, 再大只不过是重复而已，
            for (int j = 1; j <= i - j; j++) {
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                // 而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question343 question343 = new Question343();
        System.out.println(question343.integerBreak(10));
    }
}
