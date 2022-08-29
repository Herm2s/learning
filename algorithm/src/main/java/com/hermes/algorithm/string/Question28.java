package com.hermes.algorithm.string;

/**
 * kmp算法
 *
 * @author liu.zongbin
 * @since 2022/8/29
 */
public class Question28 {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        // 取得前缀表
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    private static void getNext(int[] next, String s) {
        // j指向子串的开始位置
        int j = 0;
        next[0] = 0;
        // i指向子串的结束位置
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("abcafabcab", "abcab"));
    }
}
