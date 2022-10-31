package com.hermes.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/10/31
 */
public class Question448 {

    /**
     * 普通解法
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] path = new int[nums.length + 1];
        for (int num : nums) {
            path[num] = 1;
        }
        for (int i = 1; i < path.length; i++) {
            if (path[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 原地修改
     * 遍历数组，对num-1位置的数字+len，
     * 然后检查数组 ，没有>len的位置的后一个位置，就是没出现过的数字
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        for (int num : nums) {
            // 1. 对num-1位置的数字+len
            // 2. 因为num-1可能被修改过（nums中会有重复数字），所以要取模还原出原来的值
            int i = (num - 1) % len;
            nums[i] += len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question448 question448 = new Question448();
        System.out.println(question448.findDisappearedNumbers1(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
