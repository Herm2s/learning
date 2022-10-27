package com.hermes.algorithm.array;

/**
 * @author liu.zongbin
 * @since 2022/10/27
 */
public class Question1822 {

    public int arraySign(int[] nums) {
        // 1表示正数，-1表示负数
        int sign = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                sign = -sign;
            }
        }
        return sign;
    }

    public static void main(String[] args) {
        Question1822 question1822 = new Question1822();
        System.out.println(question1822.arraySign(new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41}));
    }
}
