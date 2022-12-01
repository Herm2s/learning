package com.hermes.algorithm.string;

/**
 * 最长公共前缀
 *
 * @author liu.zongbin
 * @since 2022/11/30
 */
public class Question14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < result.length()
                    && j < strs[i].length()
                    && result.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            result = result.substring(0, j);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        Question14 question14 = new Question14();
        System.out.println(question14.longestCommonPrefix(strs));
    }
}
