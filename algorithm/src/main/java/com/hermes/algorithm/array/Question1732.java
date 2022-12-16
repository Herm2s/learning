package com.hermes.algorithm.array;

/**
 * 找到最高海拔
 *
 * @author herm2s
 * @since 2022/11/19 11:13
 */
public class Question1732 {

    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int num : gain) {
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Question1732 question1732 = new Question1732();
        System.out.println(question1732.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    }
}
