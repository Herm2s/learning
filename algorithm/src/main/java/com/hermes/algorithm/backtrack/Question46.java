package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/9/22
 */
public class Question46 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Question46 question46 = new Question46();
        System.out.println(question46.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return result;
    }

    public void backtracking(int[] nums) {
        if (nums.length == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            backtracking(nums);
            path.removeLast();
        }
    }
}
