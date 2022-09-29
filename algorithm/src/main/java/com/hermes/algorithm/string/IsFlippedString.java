package com.hermes.algorithm.string;

/**
 * 面试题 01.09. 字符串轮转
 *
 * @author liu.zongbin
 * @since 2022/9/29
 */
public class IsFlippedString {

    public static boolean isFlippedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public static boolean isFlippedString1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
        int m = s1.length();
        for (int i = 1; i < m; i++) {
            String s1a = s1.substring(0, i);
            String s1b = s1.substring(i, m);
            String s2a = s2.substring(m - i, m);
            String s2b = s2.substring(0, m - i);
            if (s1a.equals(s2a) && s1b.equals(s2b)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isFlippedString("waterbottle", "erbottlewat"));
    }
}
