package com.hermes.algorithm.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 最长连续序列
 *
 * @author liu.zongbin
 * @since 2022/11/4
 */
public class Question128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        int result = 0;
        for (int num : set) {
            // 跳过已经处理的数字
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentCount = 1;
                // 循环向后寻找下一个数
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentCount += 1;
                }

                result = Math.max(result, currentCount);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question128 question128 = new Question128();
        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println(question128.longestConsecutive(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
