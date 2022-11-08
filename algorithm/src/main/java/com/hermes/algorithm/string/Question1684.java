package com.hermes.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 统计一致字符串的数目
 *
 * @author liu.zongbin
 * @since 2022/11/8
 */
public class Question1684 {

    /**
     * set
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = allowed.toCharArray();
        for (char c : chars) {
            set.add(c);
        }
        for (String word : words) {
            char[] c1 = word.toCharArray();
            int num = 1;
            for (char c : c1) {
                if (!set.contains(c)) {
                    num = 0;
                    break;
                }
            }
            count += num;
        }
        return count;
    }

    /**
     * 位运算
     */
    public int countConsistentStrings1(String allowed, String[] words) {
        // 32位整数，每一位为1的话代表对应位置的字母出现过
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            if ((mask1 | mask) == mask) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question1684 question1684 = new Question1684();
        System.out.println(question1684.countConsistentStrings("ab",
                new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }
}
