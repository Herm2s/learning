package com.hermes.algorithm.string;

/**
 * 最长回文子串
 *
 * @author liu.zongbin
 * @since 2022/11/1
 */
public class Question5 {

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 回文子串中心可能是一个字符("aba")
            // 也可能是两个("abba")
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            // 求出两种可能的回文子串长度，取最大值即可
            int len = Math.max(len1, len2);
            // 如果本次回文子串比上次的大，重新记录最长回文子串开始下标和结束下标
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
            // 特例：字符串s整个就是一个回文字符串，直接跳出循环即可
            if ((end - start) + 1 == s.length()) {
                break;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩展算法
     * 求出以当前下标为中心的最长回文子串长度
     */
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Question5 question5 = new Question5();
        System.out.println(question5.longestPalindrome("babad"));
    }
}
