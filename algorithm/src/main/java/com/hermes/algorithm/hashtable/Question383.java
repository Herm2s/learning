package com.hermes.algorithm.hashtable;

/**
 * @author liu.zongbin
 * @since 2022/9/26
 */
public class Question383 {

    public static void main(String[] args) {
        Question383 question383 = new Question383();
        System.out.println(question383.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // 用一个长度为26的数组还记录magazine里字母出现的次数
        int[] records = new int[26];
        for (char c : magazine.toCharArray()) {
            records[c - 'a'] += 1;
        }

        // 再用ransomNote去验证这个数组是否包含了ransomNote所需要的所有字母
        for (char c : ransomNote.toCharArray()) {
            records[c - 'a'] -= 1;
        }

        // records包含负数则不满足
        for (int num : records) {
            if (num < 0) {
                return false;
            }
        }
        return true;
    }
}
