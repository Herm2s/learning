package com.hermes.algorithm.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 判断字符串的两半是否相似
 *
 * @author liu.zongbin
 * @since 2022/11/11
 */
public class Question1704 {

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int left = 0;
        int right = s.length() - 1;
        int leftCount = 0;
        int rightCount = 0;
        while (left < right) {
            if (set.contains(s.charAt(left))) {
                leftCount++;
            }
            if (set.contains(s.charAt(right))) {
                rightCount++;
            }
            left++;
            right--;
        }
        return leftCount == rightCount;
    }

    public static void main(String[] args) {
        Question1704 question1704 = new Question1704();
        System.out.println(question1704.halvesAreAlike("book"));
    }
}
