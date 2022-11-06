package com.hermes.algorithm.dp;

/**
 * 回文子串
 *
 * @author herm2s
 * @since 2022/11/6 12:23
 */
public class Question647 {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Question647 question647 = new Question647();
        System.out.println(question647.countSubstrings("aaaa"));
    }
}
