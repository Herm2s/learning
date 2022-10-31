package com.hermes.algorithm.backtrack;

/**
 * 目标和
 *
 * @author liu.zongbin
 * @since 2022/10/31
 */
public class Question494 {

    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return result;
    }

    void backtrack(int[] nums, int target, int start, int sum) {
        if (start == nums.length) {
            // 收集结果
            if (sum == target) {
                result++;
            }
        } else {
            // 每次递归并没有改变sum的值，也是一种回溯
            backtrack(nums, target, start + 1, sum + nums[start]);
            backtrack(nums, target, start + 1, sum - nums[start]);
        }
    }

    public static void main(String[] args) {
        Question494 question494 = new Question494();
        System.out.println(question494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
