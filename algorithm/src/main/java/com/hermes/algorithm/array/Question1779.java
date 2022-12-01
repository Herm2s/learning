package com.hermes.algorithm.array;

/**
 * 找到最近的有相同Х或Y坐标的点
 *
 * @author liu.zongbin
 * @since 2022/12/1
 */
public class Question1779 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int px = point[0];
            int py = point[1];
            if (px == x || py == y) {
                int distance = Math.abs(x - px) + Math.abs(y - py);
                if (distance < min) {
                    min = distance;
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question1779 question1779 = new Question1779();
        int[][] points = {
                {1, 2},
                {3, 1},
                {2, 4},
                {2, 3},
                {4, 4}};
        System.out.println(question1779.nearestValidPoint(3, 4, points));
    }
}
