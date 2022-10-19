package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 递增子序列
 *
 * @author liu.zongbin
 * @since 2022/10/19
 */
public class Question497 {

    List<List<Integer>> result = new ArrayList<>();

    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            // 使用过了当前数字
            if (map.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Question497 question497 = new Question497();
        // 4,4,3,2,1
        // 4,6,7,7
        System.out.println(question497.findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
