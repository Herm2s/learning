package com.hermes.algorithm.backtrack;

import java.util.*;

/**
 * @author liu.zongbin
 * @since 2022/9/12 19:28
 */
public class Question39 {

    static List<List<Integer>> result = new ArrayList<>();

    static Deque<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return result;
    }

    static void backTracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            backTracking(candidates, target, sum + candidates[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
