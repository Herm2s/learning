package com.hermes.algorithm.hashtable;

/**
 * 面试题 01.02. 判定是否互为字符重排
 *
 * @author liu.zongbin
 * @since 2022/9/27
 */
public class CheckPermutation {

    public static void main(String[] args) {
        CheckPermutation permutation = new CheckPermutation();
        System.out.println(permutation.CheckPermutation("abc", "bad"));
    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] record = new int[26];
        char[] chars2 = s2.toCharArray();
        for (char c2 : chars2) {
            record[c2 - 'a'] += 1;
        }

        char[] chars1 = s1.toCharArray();
        for (char c1 : chars1) {
            record[c1 - 'a'] -= 1;
        }
        for (int i : record) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
