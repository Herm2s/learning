package com.hermes.algorithm.hashtable;

/**
 * @author liu.zongbin
 * @since 2022/8/20 11:31
 */
public class Question242 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];

        char[] sChar = s.toCharArray();
        for (char c : sChar) {
            // char类型相减结果=字母在ASCII表里的位置差
            int offset = c - 'a';
            hash[offset]++;
        }

        char[] tChar = t.toCharArray();

        for (char c : tChar) {
            // char类型相减结果=字母在ASCII表里的位置差
            int offset = c - 'a';
            hash[offset]--;
        }
        for (int i : hash) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] c = {'b', 'f', 'a'};
        System.out.println(c[1] - 'h');
    }
}
