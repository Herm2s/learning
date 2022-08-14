package com.hermes.algorithm.array;

/**
 * 209
 *
 * @author liu.zongbin
 * @since 2022/8/13 13:02
 */
public class Question209 {

    /**
     * 滑动窗口
     * [2,3,1,2,4,3]
     * i和j都从起始位置开始滑动
     */
    public static int minSubArrayLen(int target, int[] nums) {
        // 结果
        int result = nums.length;
        // 窗口内元素之和
        int sum = 0;
        // 窗口左边
        int i = 0;
        boolean flag = false;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 只要窗口内的元素和不大于等于target，窗口右边界就向前移动
            // 一旦窗口内元素和满足条件了，就先记录下窗口当前大小，然后窗口左边界向前移动，看看是否有更短的结果
            while (sum >= target) {
                flag = true;
                // 当前窗口的长度
                int subLen = j - i + 1;
                // 更新为较小的窗口
                result = Math.min(subLen, result);
                // 移动窗口，要先减掉移出窗口的值
                sum = sum - nums[i];
                i++;
            }
        }
        return flag ? result : 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
