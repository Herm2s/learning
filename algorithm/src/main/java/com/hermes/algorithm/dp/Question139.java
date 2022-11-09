package com.hermes.algorithm.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 单词拆分
 *
 * @author liu.zongbin
 * @since 2022/11/9
 */
public class Question139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return false;
    }

    public static void main(String[] args) {
        Question139 question139 = new Question139();
        System.out.println(question139.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }
}
