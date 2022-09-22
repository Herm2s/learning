package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/9/22
 */
public class Question40 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    private int sum = 0;

    public static void main(String[] args) {
        Question40 question40 = new Question40();
        List<List<Integer>> lists = question40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            int num = candidates[i];
            // 跳过本层已经遍历过的元素
            if (i > startIndex && num == candidates[i - 1]) {
                continue;
            }

            path.add(num);
            sum += num;
            backtracking(candidates, target, i + 1);
            // 回溯
            sum -= path.getLast();
            path.removeLast();
        }
    }
}
