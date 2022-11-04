package com.hermes.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author liu.zongbin
 * @since 2022/11/4
 */
public class Question56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(nums -> nums[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            // 当前的left跟上一个的right比较
            if (result.isEmpty() || result.get(result.size() - 1)[1] < left) {
                result.add(new int[]{left, right});
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], right);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Question56 question56 = new Question56();
        // [1,3], [2,6], [8,10], [15,18]
        int[][] merge = question56.merge(new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        });
        System.out.println(merge);
    }
}
