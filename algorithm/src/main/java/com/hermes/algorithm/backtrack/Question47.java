package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/9/30
 */
public class Question47 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Question47 question47 = new Question47();
        System.out.println(question47.permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        backTrack(nums, 0);
        return result;
    }

    void backTrack(int[] nums, int startIndex) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[startIndex]);
        backTrack(nums, startIndex + 1);
        path.removeLast();
    }
}
