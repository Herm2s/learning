package com.hermes.algorithm.bit;

/**
 * 2的幂
 *
 * @author liu.zongbin
 * @since 2022/12/5
 */
public class Question231 {

    public boolean isPowerOfTwo(int n) {
        final int BIG = 2 << 30;
        return n > 0 && BIG % n == 0;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & -n) == n;
    }

    public static void main(String[] args) {
        Question231 question231 = new Question231();
        System.out.println(question231.isPowerOfTwo(4));
    }
}
