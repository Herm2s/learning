package com.hermes.algorithm.dp;

/**
 * 完全平方数
 *
 * @author liu.zongbin
 * @since 2022/11/9
 */
public class Question279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏情况
            dp[i] = i;
            // 循环匹配每个平方
            for (int j = 1; i - j * j >= 0; j++) {
                // 递推公式： i-j*j位置的num，再加上j*j这1种情况就是dp[i]了，跟原来的比较取较小值
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question279 question279 = new Question279();
        System.out.println(question279.numSquares(12));
    }
}
