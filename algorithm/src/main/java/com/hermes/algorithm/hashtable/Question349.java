package com.hermes.algorithm.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liu.zongbin
 * @since 2022/8/20 11:31
 */
public class Question349 {

    /**
     * set解法
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        // Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 数组解法
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        int[] hash = new int[1000];
        for (int i : nums1) {
            hash[i] = 1;
        }

        Set<Integer> result = new HashSet<>();
        int index = 0;
        for (int i : nums2) {
            if (hash[i] == 1) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[6];

        System.out.println(Arrays.toString(nums1));
    }
}
