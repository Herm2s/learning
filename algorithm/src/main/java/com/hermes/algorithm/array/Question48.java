package com.hermes.algorithm.array;

/**
 * 旋转图像
 *
 * @author liu.zongbin
 * @since 2022/11/2
 */
public class Question48 {

    /**
     * 先沿右上-左下对角线翻转，然后沿水平中线180度翻转
     * 1, 2, 3       9 6 3       7 4 1
     * 4, 5, 6  -->  8 5 2  -->  8 5 2
     * 7, 8, 9       7 4 1       9 6 3
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                // 00,22 01,12 10,21 n=3
                // i=0 j=0  a=2 b=2
                // i=0 j=1  a=1 b=2
                // i=1 j=0  a=2 b=1
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
        // 水平中线翻转
        for (int i = 0; i < n >> 1; i++) {
            for (int j = 0; j < n; j++) {
                // 00,20 01,21 02,22
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Question48 question48 = new Question48();
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        question48.rotate(matrix);
        System.out.println();
    }
}
