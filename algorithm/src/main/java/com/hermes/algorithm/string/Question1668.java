package com.hermes.algorithm.string;

import java.util.Collections;

/**
 * 最大重复子字符串
 *
 * @author liu.zongbin
 * @since 2022/11/3
 */
public class Question1668 {

    public int maxRepeating(String sequence, String word) {
        // 枚举每个可能重复的次数k
        for (int k = sequence.length() / word.length(); k > 0; k--) {
            if (sequence.contains(String.join("", Collections.nCopies(k, word)))) {
                return k;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Question1668 question1668 = new Question1668();
        System.out.println(question1668.maxRepeating("ababc", "ab"));
    }
}
