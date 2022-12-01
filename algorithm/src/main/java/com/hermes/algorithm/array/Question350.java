package com.hermes.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集 II
 *
 * @author liu.zongbin
 * @since 2022/12/1
 */
public class Question350 {

    /**
     * 哈希表
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.merge(i, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            Integer count = map.getOrDefault(i, 0);
            if (count > 0) {
                map.put(i, --count);
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 排序 + 双指针
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[Math.min(len1, len2)];
        int index = 0, index1 = 0, index2 = 0;
        // 2, 2
        // 1, 1, 2, 2
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums2[index2] < nums1[index1]) {
                index2++;
            } else {
                // 相等
                arr[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }

    public static void main(String[] args) {
        Question350 question350 = new Question350();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(question350.intersect1(nums1, nums2)));
    }
}
