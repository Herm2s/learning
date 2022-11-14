package com.hermes.algorithm.string;

/**
 * 找不同
 *
 * @author herm2s
 * @since 2022/11/12 12:33
 */
public class Question389 {

    /**
     * 计数
     */
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            char ch = t.charAt(j);
            if (--cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /**
     * 求和
     */
    public char findTheDifference1(String s, String t) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < s.length(); i++) {
            sum1 += s.charAt(i);
        }
        for (int j = 0; j < t.length(); j++) {
            sum2 += t.charAt(j);
        }
        return (char) (sum2 - sum1);
    }

    /**
     * 位运算
     * 同136.只出现一次的数字
     */
    public char findTheDifference2(String s, String t) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i);
        }
        for (int j = 0; j < t.length(); j++) {
            result ^= t.charAt(j);
        }
        return (char) result;
    }


    public static void main(String[] args) {
        Question389 question389 = new Question389();
        System.out.println(question389.findTheDifference2("abcd", "dabct"));
    }
}
