package com.hermes.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中不同整数的数目
 *
 * @author liu.zongbin
 * @since 2022/12/6
 */
public class Question1805 {

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                // 跳过前导0
                while (i < word.length() && word.charAt(i) == '0') {
                    i++;
                }
                int j = i;
                while (j < word.length() && Character.isDigit(word.charAt(j))) {
                    j++;
                }
                set.add(word.substring(i, j));
                i = j;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Question1805 question1805 = new Question1805();
        System.out.println(question1805.numDifferentIntegers("a123bc34d8ef34"));
    }
}
