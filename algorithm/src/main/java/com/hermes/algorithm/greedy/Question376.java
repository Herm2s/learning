package com.hermes.algorithm.greedy;

/**
 * 摆动序列
 *
 * @author liu.zongbin
 * @since 2022/10/25
 */
public class Question376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        // 当前差值
        int curDiff = 0;
        // 上一个差值
        int preDiff = 0;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Question376 question376 = new Question376();
        System.out.println(question376.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }
}
