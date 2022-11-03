package com.hermes.algorithm.dp;

/**
 * 不同路径
 *
 * @author liu.zongbin
 * @since 2022/11/3
 */
public class Question62 {

    /**
     * 动态规划
     */
    public int uniquePaths(int m, int n) {
        // dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径
        int[][] dp = new int[m][n];
        // 初始化dp数组
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 组合法
     */
    public int uniquePaths1(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }


    public static void main(String[] args) {
        Question62 question62 = new Question62();
        System.out.println(question62.uniquePaths(3, 2));
    }
}
