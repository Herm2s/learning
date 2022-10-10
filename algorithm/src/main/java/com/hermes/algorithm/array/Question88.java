package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * @author liu.zongbin
 * @since 2022/10/10
 */
public class Question88 {

    public static void main(String[] args) {
        Question88 question88 = new Question88();
        int[] nums1 = {1, 2, 0, 0};
        int[] nums2 = {3, 4};
        question88.merge(nums1, 2, nums2, 2);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while (j >= 0) {
            // i >= 0是避免 nums1 = {0}的情况
            if (i >= 0 && nums1[i] > nums2[j]) {
                // nums1 > nums2,则把nums1[m]放到nums1数组后面,m再自减一
                nums1[i + j + 1] = nums1[i--];
            } else {
                // nums2 >= nums1,则把nums2[n]放到nums1数组后面,n再自减一
                nums1[i + j + 1] = nums2[j--];
            }
        }
    }
}
