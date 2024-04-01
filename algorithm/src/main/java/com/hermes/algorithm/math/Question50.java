package com.hermes.algorithm.math;

/**
 * 快速幂
 *
 * @author liu.zongbin
 * @since 2023/4/21
 */
public class Question50 {

    public double myPow(double x, int n) {
        long N = n;
        if (N >= 0) {
            return quickMul(x, N);
        }
        return 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        Question50 question50 = new Question50();
        System.out.println(question50.myPow(2D, 7));
    }
}
