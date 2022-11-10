package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * 只出现一次的数字
 *
 * @author liu.zongbin
 * @since 2022/11/10
 */
public class Question136 {

    /**
     * 排序
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 位运算
     * 1. 任何数和0做异或运算，结果仍然是原来的数，即 a^0=a。
     * 2. 任何数和其自身做异或运算，结果是0，即 a^a=0。
     * 3. 异或运算满足交换律和结合律，即 a^b^a = b^a^a = b^(a^a) = b^0 = b。
     */
    public int singleNumber1(int[] nums) {
        int result = 0;
        for (int num : nums) {
            // 根据异或的性质，出现两次的数字异或之后为0，再异或出现一次的数字，就是结果
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        Question136 question136 = new Question136();
        // 1 1 2 4 4
        System.out.println(question136.singleNumber1(new int[]{4, 1, 2, 1, 2}));
    }
}
