package com.hermes.algorithm.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 *
 * @author liu.zongbin
 * @since 2022/11/9
 */
public class Question139 {

    private Set<String> set;

    private int[] memo;

    /**
     * 回溯
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 记录从starIndex开始能不能找到
        memo = new int[s.length()];
        set = new HashSet<>(wordDict);
        return backtrack(s, 0);
    }

    private boolean backtrack(String s, int startIndex) {
        if (startIndex == s.length()) {
            return true;
        }
        if (memo[startIndex] == -1) {
            return false;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (!set.contains(sub)) {
                continue;
            }
            boolean res = backtrack(s, i + 1);
            if (res) {
                return true;
            }
        }
        // 这里是关键，找遍了startIndex~s.length()也没能完全匹配，标记从startIndex开始不能找到
        memo[startIndex] = -1;
        return false;
    }

    /**
     * 动态规划
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        // dp[i] = 1：表示[0~i]的子串可以拆分为一个或多个在字典中出现的单词
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                // if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true
                if (i >= len && dp[i - len] == 1 && word.equals(s.substring(i - len, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }

    public static void main(String[] args) {
        Question139 question139 = new Question139();
        System.out.println(question139.wordBreak1("leetcode", Arrays.asList("leet", "code")));
    }
}
