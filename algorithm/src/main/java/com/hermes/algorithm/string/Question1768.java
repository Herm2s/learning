package com.hermes.algorithm.string;

/**
 * @author herm2s
 * @since 2022/10/23 15:19
 */
public class Question1768 {

    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;
        StringBuilder result = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                result.append(word1.charAt(i++));
            }
            if (j < n) {
                result.append(word2.charAt(j++));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Question1768 question1768 = new Question1768();
        System.out.println(question1768.mergeAlternately("abc", "pqr"));
        System.out.println((((2 << 21) | 2) >> 12));
    }
}
