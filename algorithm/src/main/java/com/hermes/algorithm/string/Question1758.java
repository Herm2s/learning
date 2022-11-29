package com.hermes.algorithm.string;

/**
 * 生成交替二进制字符串的最少操作数
 *
 * @author liu.zongbin
 * @since 2022/11/29
 */
public class Question1758 {

    public int minOperations(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 偶数位置是0，奇数位置是1，统计需要变换的次数
            if (c != (char) ('0' + i % 2)) {
                count++;
            }
        }
        // 取两种变换种最小的
        return Math.min(count, s.length() - count);
    }

    public static void main(String[] args) {
        Question1758 question1758 = new Question1758();
        System.out.println(question1758.minOperations("1011"));
    }
}
