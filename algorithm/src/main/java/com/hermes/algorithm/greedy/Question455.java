package com.hermes.algorithm.greedy;

import java.util.Arrays;

/**
 * 分发饼干
 *
 * @author liu.zongbin
 * @since 2022/10/25
 */
public class Question455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int result = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question455 question455 = new Question455();
        int result = question455.findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8});
        System.out.println(result);
    }
}
