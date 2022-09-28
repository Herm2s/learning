package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/9/28
 */
public class Question78 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Question78 question78 = new Question78();
        System.out.println(question78.subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return result;
    }

    void backTrack(int[] nums, int cur) {
        if (cur == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        path.add(nums[cur]);
        backTrack(nums, cur + 1);
        path.removeLast();
        backTrack(nums, cur + 1);
    }
}
