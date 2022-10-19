package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/9/30
 */
public class Question47 {

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    void backTrack(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            if (used[i] == 0) {
                used[i] = 1;
                path.add(nums[i]);
                backTrack(nums, used);
                path.removeLast();
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Question47 question47 = new Question47();
        System.out.println(question47.permuteUnique(new int[]{1, 2, 3}));
    }
}
