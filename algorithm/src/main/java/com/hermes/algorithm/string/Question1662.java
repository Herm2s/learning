package com.hermes.algorithm.string;

/**
 * @author liu.zongbin
 * @since 2022/11/1
 */
public class Question1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int p1 = 0, p2 = 0;
        int i = 0, j = 0;
        while (p1 < word1.length && p2 < word2.length) {
            if (word1[p1].charAt(i) != word2[p2].charAt(j)) {
                return false;
            }
            i++;
            if (i == word1[p1].length()) {
                i = 0;
                p1++;
            }
            j++;
            if (j == word2[p2].length()) {
                j = 0;
                p2++;
            }
        }
        return p1 == word1.length && p2 == word2.length;
    }

    /**
     * 普通解法
     */
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (String s : word1) {
            sb.append(s);
        }
        StringBuilder sb1 = new StringBuilder();
        for (String s : word2) {
            sb1.append(s);
        }
        return sb.toString().equals(sb1.toString());
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

    public static void main(String[] args) {
        Question1662 question1662 = new Question1662();
        System.out.println(question1662.arrayStringsAreEqual(
                new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }
}
