package com.hermes.algorithm.dp;

/**
 * 最小路径和
 *
 * @author liu.zongbin
 * @since 2022/11/4
 */
public class Question64 {

    /**
     * 动态规划
     */
    public int minPathSum(int[][] grid) {
        // dp[i][j]: 走到i,j位置的最小和
        // dp[i][j] = dp[i-1][j] + grid[i][j] 和 dp[i][j-1] + grid[i][j]中的较小者
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    // 上面没值
                    dp[i][j] = dp[0][j - 1] + grid[i][j];
                } else if (j == 0) {
                    // 左边没值
                    dp[i][j] = dp[i - 1][0] + grid[i][j];
                } else {
                    // 左和上都有值
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 动态规划——原地修改数组
     */
    public int minPathSum1(int[][] grid) {
        // dp[i][j]: 走到i,j位置的最小和
        // dp[i][j] = dp[i-1][j] + grid[i][j] 和 dp[i][j-1] + grid[i][j]中的较小者
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    // 上面没值
                    grid[i][j] = grid[0][j - 1] + grid[i][j];
                } else if (j == 0) {
                    // 左边没值
                    grid[i][j] = grid[i - 1][0] + grid[i][j];
                } else {
                    // 左和上都有值
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Question64 question64 = new Question64();
        System.out.println(question64.minPathSum1(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        }));
    }
}
