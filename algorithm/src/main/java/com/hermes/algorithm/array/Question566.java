package com.hermes.algorithm.array;

/**
 * @author liu.zongbin
 * @since 2022/12/1
 */
public class Question566 {

    public int[][] matrixReshape(int[][] mat, int nRow, int nCol) {
        int row = mat.length;
        int col = mat[0].length;
        if (row * col != nRow * nCol) {
            return mat;
        }
        int[][] result = new int[nRow][nCol];
        for (int x = 0; x < row * col; x++) {
            result[x / nCol][x % nCol] = mat[x / col][x % col];
        }
        return result;
    }

    public static void main(String[] args) {
        Question566 question566 = new Question566();
        int[][] mat = {{1, 2}, {3, 4}};
        int[][] result = question566.matrixReshape(mat, 1, 4);
        System.out.println();
    }
}
