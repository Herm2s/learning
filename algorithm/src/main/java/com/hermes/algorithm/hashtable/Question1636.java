package com.hermes.algorithm.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author liu.zongbin
 * @since 2022/9/19
 */
public class Question1636 {

    public static void main(String[] args) {
        Question1636 question1636 = new Question1636();
        System.out.println(Arrays.toString(question1636.frequencySort(new int[]{1, 3, 3, 2, 2})));
    }

    public int[] frequencySort(int[] nums) {
        // key: 数字，value: 次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        numList.sort((a, b) -> {
            Integer aCount = map.get(a);
            Integer bCount = map.get(b);
            return !Objects.equals(aCount, bCount) ? aCount - bCount : b - a;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numList.get(i);
        }
        return nums;
    }
}
