package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和III
 *
 * @author herm2s
 * @since 2022/10/18 20:07
 */
public class Question216 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    private int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.backTrack(k, n, 1);
        return result;
    }

    private void backTrack(int k, int n, int startIndex) {
        // 剪枝
        if (sum > n) {
            return;
        }
        if (sum == n && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // i <= 9 - (k - path.size()) + 1 剪枝
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTrack(k, n, i + 1);
            path.removeLast();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        Question216 question216 = new Question216();
        System.out.println(question216.combinationSum3(3, 24));
    }
}
