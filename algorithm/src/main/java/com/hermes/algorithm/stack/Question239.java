package com.hermes.algorithm.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liu.zongbin
 * @since 2022/9/4 11:59
 */
public class Question239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int length = nums.length - k + 1;
        int[] result = new int[length];
        int num = 0;
        Queue queue = new Queue();
        // 先将前k个元素放入队列
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        result[num++] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            // 移除left
            queue.poll(nums[i - k]);
            // 加入right
            queue.add(nums[i]);
            // 记录最大值
            result[num++] = queue.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

    static class Queue {

        private final Deque<Integer> deque = new LinkedList<>();

        void poll(Integer value) {
            // 弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
            // 如果不相等，说明是比较小的元素，在add时已经被移除了
            if (!deque.isEmpty() && value.equals(deque.peek())) {
                deque.poll();
            }
        }

        void add(int value) {
            // 每次加入元素时，如果比前面的元素大，则移除前面的元素
            while (!deque.isEmpty() && value > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(value);
        }

        Integer peek() {
            //队列队顶元素始终为最大值
            return deque.peek();
        }
    }
}