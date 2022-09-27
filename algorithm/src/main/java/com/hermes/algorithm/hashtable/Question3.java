package com.hermes.algorithm.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liu.zongbin
 * @since 2022/9/27
 */
public class Question3 {

    public static void main(String[] args) {
        Question3 question3 = new Question3();
        System.out.println(question3.lengthOfLongestSubstring1("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int right = -1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(right + 1));
                ++right;
            }
            // 第 i 到 right 个字符是一个极长的无重复字符子串
            result = Math.max(result, right - i + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring1(String s) {
        // abcabcbb
        Set<Character> set = new HashSet<>();
        int n = s.length();
        // 右指针
        int right = -1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 移动左指针
                set.remove(s.charAt(i - 1));
            }
            // 不断移动右指针
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            result = Math.max(result, right - i + 1);
        }
        return result;
    }
}
