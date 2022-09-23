package com.hermes.algorithm.math;

/**
 * @author liu.zongbin
 * @since 2022/9/23
 */
public class Question7 {

    public static void main(String[] args) {
        Question7 question7 = new Question7();
        // 123321
        System.out.println(question7.isPalindrome(12321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        // 反转后半部分数字，跟前一半比较
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + (x % 10);
            x /= 10;
        }
        return revertedNumber == x || revertedNumber / 10 == x;
    }
}
