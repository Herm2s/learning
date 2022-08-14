package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * @author liu.zongbin
 * @since 2022/8/14 12:14
 */
public class Question59 {

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 控制循环次数
        int loop = 0;
        // 每次循环的开始点(start, start)
        int start = 0;
        // 定义填充数字
        int num = 1;
        int x, y;

        // 判断边界后，loop从1开始
        while (loop++ < n / 2) {
            // 模拟上侧从左到右
            for (y = start; y < n - loop; y++) {
                result[start][y] = num++;
            }

            // 模拟右侧从上到下
            for (x = start; x < n - loop; x++) {
                result[x][y] = num++;
            }

            // 模拟下侧从右到左
            for (; y >= loop; y--) {
                result[x][y] = num++;
            }

            // 模拟左侧从下到上
            for (; x >= loop; x--) {
                result[x][y] = num++;
            }
            // start每一次循环都要+1
            start++;
        }

        if (n % 2 == 1) {
            result[start][start] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
