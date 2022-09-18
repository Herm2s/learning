package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/9/18 18:24
 */
public class Question131 {

    private List<List<String>> result = new ArrayList<>();

    private LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        Question131 question131 = new Question131();
        System.out.println(question131.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        this.backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, i + 1);
            if (isPalindrome(str)) {
                // 如果字串是回文的话就收集
                path.add(str);
            } else {
                // 一个不是的话也没有必要遍历后面的了
                continue;
            }
            backtracking(s, i + 1);
            // 回溯
            path.removeLast();
        }
    }

    /**
     * 判断是否回文字符串
     */
    private boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start <= end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
