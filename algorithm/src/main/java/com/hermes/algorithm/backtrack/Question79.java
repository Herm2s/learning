package com.hermes.algorithm.backtrack;

/**
 * 单词搜索
 *
 * @author liu.zongbin
 * @since 2022/10/31
 */
public class Question79 {

    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // 以每个i，j为起点搜索
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            // 首字母就不符合
            return false;
        } else if (k == word.length() - 1) {
            // 满足搜索条件
            return true;
        }
        boolean result = false;
        // 方向：上、下、左、右
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // 记录位置为已搜索
        visited[i][j] = true;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0
                    && newi < board.length
                    && newj >= 0
                    && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, word, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        // 回溯
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        Question79 question79 = new Question79();
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}};
        System.out.println(question79.exist(board, "ABCCED"));
    }
}
