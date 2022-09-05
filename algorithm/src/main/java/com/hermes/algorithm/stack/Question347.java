package com.hermes.algorithm.stack;

import java.util.*;

/**
 * @author liu.zongbin
 * @since 2022/9/4 13:04
 */
public class Question347 {

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        // key: num，value: count
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        // 小顶堆，int[] 的第一个元素就是num，第二个元素就是count
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    // 移除根节点
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
