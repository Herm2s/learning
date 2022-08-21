package com.hermes.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu.zongbin
 * @since 2022/8/21 12:05
 */
public class Question454 {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.merge(i + j, 1, Integer::sum);
            }
        }

        int result = 0;
        for (int k : nums3) {
            for (int l : nums4) {
                int num = -(k + l);
                if (map.containsKey(num)) {
                    result += map.get(num);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, -1};
        int[] nums2 = {-1, 1, 0};
        int[] nums3 = {0, 0, 1};
        int[] nums4 = {-1, 1, 1};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
