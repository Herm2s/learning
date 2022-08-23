package com.hermes.algorithm.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/8/23 20:50
 */
public class Question18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0 && nums[k] > target) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for (int i = k + 1; i < nums.length - 1; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[k] + nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // 找到答案时，双指针同时收缩
                        right--;
                        left++;
                    } else if (sum > target) {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        System.out.println(fourSum(nums, 0));
    }
}
