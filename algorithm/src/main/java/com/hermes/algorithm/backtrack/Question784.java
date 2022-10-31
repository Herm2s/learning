package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 *
 * @author liu.zongbin
 * @since 2022/10/31
 */
public class Question784 {

    private final List<String> result = new ArrayList<>();

    /**
     * 输入：s = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     */
    public List<String> letterCasePermutation(String s) {
        backtrack(s.toCharArray(), 0);
        return result;
    }

    void backtrack(char[] chars, int start) {
        // 跳过数字
        while (start < chars.length && Character.isDigit(chars[start])) {
            start++;
        }
        // 收集结果
        if (start == chars.length) {
            result.add(new String(chars));
            return;
        }
        // 转换大小写
        chars[start] ^= 32;
        backtrack(chars, start + 1);
        // 回溯
        chars[start] ^= 32;
        backtrack(chars, start + 1);
    }

    public static void main(String[] args) {
        Question784 question784 = new Question784();
        System.out.println(question784.letterCasePermutation("a1b2"));
    }
}
