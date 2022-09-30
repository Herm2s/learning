package com.hermes.algorithm.matrix;

import java.util.Arrays;

/**
 * 面试题 01.08. 零矩阵
 *
 * @author liu.zongbin
 * @since 2022/9/30
 */
public class SetZeroes {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[x][y] == 0) {
                    row[x] = col[y] = true;
                }
            }
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (row[x] || col[y]) {
                    matrix[x][y] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1}
        };
        setZeroes(matrix);
        System.out.println(Arrays.toString(matrix));
    }
}
