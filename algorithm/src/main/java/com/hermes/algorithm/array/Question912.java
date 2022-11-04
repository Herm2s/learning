package com.hermes.algorithm.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组排序
 *
 * @author liu.zongbin
 * @since 2022/8/14 13:11
 */
public class Question912 {

    class Quicksort1 {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }

            int point = partition(nums, left, right);
            quickSort(nums, left, point - 1);
            quickSort(nums, point + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            int i = left;
            // 随机挑选一个幸运儿
            int q = new Random().nextInt(right - left + 1) + left;
            swap(nums, right, q);

            for (int j = left; j < right; ++j) {
                if (nums[j] < nums[right]) {
                    if (i != j) {
                        swap(nums, i, j);
                    }
                    i += 1;
                }
            }
            swap(nums, i, right);
            return i;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    class Quicksort2 {
        public int[] sortArray(int[] nums) {
            quicksort(nums, 0, nums.length - 1);
            return nums;
        }

        void quicksort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            // 局部分区
            int pivot = partition(nums, left, right);
            // 递归排序左右区间
            quicksort(nums, left, pivot - 1);
            quicksort(nums, pivot + 1, right);
        }

        /**
         * 局部分区
         * 将比nums[pivot]小的数放左边
         * 将比nums[pivot]大的数放右边
         */
        int partition(int[] nums, int left, int right) {
            // 随机选择基准
            int pos = new Random().nextInt(right - left) + left;
            int pivot = nums[pos];
            // pivot放置到最右边
            swap(nums, right, pos);

            // 因基准值占用数组最后位置，右指针要 -1
            int l = left, r = right - 1;
            while (l <= r) {
                while (l <= r && pivot <= nums[r]) {
                    r--;
                }
                while (l <= r && pivot >= nums[l]) {
                    l++;
                }
                if (l <= r) {
                    swap(nums, l, r);
                }
            }
            // 注意此时基准值所放位置不是 r
            swap(nums, r + 1, right);
            return r + 1;
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Question912 question912 = new Question912();
        Quicksort1 quickSort1 = question912.new Quicksort1();
        Quicksort2 quickSort2 = question912.new Quicksort2();
        System.out.println(Arrays.toString(quickSort2.sortArray(nums)));
    }
}
