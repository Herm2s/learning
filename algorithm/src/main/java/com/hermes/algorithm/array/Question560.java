package com.hermes.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 *
 * @author liu.zongbin
 * @since 2022/11/18
 */
public class Question560 {

    /**
     * 枚举
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            // 从后往前扫描子数组
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和+哈希表优化
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        // pre表示从nums[0]到nums[i]的数字之和
        int pre = 0;
        // key: 和，value出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            pre += num;
            /*
             * pre[i] = pre[i-1] + nums[i]
             * sum[j..i] = pre[i] - pre[j-1]
             * 在sum[j..i] = k的情况下，有：
             * k = pre[i] - pre[j-1]
             * pre[j-1] = pre[i] - k
             * 每次循环时，统计map里满足等式的前缀和数量，就是我们要的答案
             */
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Question560 question560 = new Question560();
        System.out.println(question560.subarraySum1(new int[]{1, 2, 3}, 3));
    }
}
