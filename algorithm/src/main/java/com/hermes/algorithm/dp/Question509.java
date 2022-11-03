package com.hermes.algorithm.dp;

/**
 * 斐波那契数列
 *
 * @author liu.zongbin
 * @since 2022/9/21 20:04
 */
public class Question509 {

    public static void main(String[] args) {
        Question509 question509 = new Question509();
        System.out.println(question509.fib2(22));
    }

    public int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        // 初始化dp数组
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        // 遍历
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 状态压缩版本
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        // 初始化dp数组
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        int sum = 0;
        // 遍历
        for (int i = 2; i <= n; i++) {
            sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return sum;
    }
}
