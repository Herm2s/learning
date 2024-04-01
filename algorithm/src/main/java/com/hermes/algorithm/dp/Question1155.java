package com.hermes.algorithm.dp;

/**
 * 1155. 掷骰子等于目标和的方法数
 *
 * @author liu.zongbin
 * @date 2023/10/24
 */
public class Question1155 {

    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int) (1e9 + 7);

        // dp[i]：n个骰子，dp[j]：点数之和，dp[i][j]储存方案数量
        // 设第i个骰子的点数为x，则前i-1个骰子的点数和为j-x
        // 可得dp公式：dp[i][j] = dp[i-1][j-x] + dp[i][j]
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= target; j++) {
                for (int x = 1; x <= k && x <= j; x++) {
                    dp[i][j] = (dp[i - 1][j - x] + dp[i][j]) % mod;
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        Question1155 question1155 = new Question1155();
        System.out.println(question1155.numRollsToTarget(2, 6, 12));
    }
}
