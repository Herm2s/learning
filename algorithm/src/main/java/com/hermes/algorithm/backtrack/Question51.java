package com.hermes.algorithm.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后
 *
 * @author herm2s
 * @since 2022/11/2 20:06
 */
public class Question51 {

    List<List<String>> result = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        backtrack(n, 0, chessboard);
        return result;
    }

    void backtrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            result.add(this.chessboard2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col, chessboard)) {
                chessboard[row][col] = 'Q';
                backtrack(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    List<String> chessboard2List(char[][] chessboard) {
        List<String> result = new LinkedList<>();
        for (char[] chars : chessboard) {
            result.add(new String(chars));
        }
        return result;
    }

    boolean isValid(int n, int row, int col, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question51 question51 = new Question51();
        System.out.println(question51.solveNQueens(4));
    }
}
