package com.hermes.algorithm.math;

/**
 * @author liu.zongbin
 * @since 2022/12/9
 */
public class Question1780 {

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
