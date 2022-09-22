package com.hermes.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu.zongbin
 * @since 2022/9/22
 */
public class Question1640 {

    public static void main(String[] args) {
        Question1640 question1640 = new Question1640();
        boolean b = question1640.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{new int[]{78}, {4, 64}, {91}});
        System.out.println(b);
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int m = pieces.length;
        // key：每个子数组首元素，value：每个子数组的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(pieces[i][0], i);
        }
        for (int i = 0; i < n; ) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            Integer index = map.get(arr[i]);
            int length = pieces[index].length;
            for (int j = 0; j < length; j++) {
                if (arr[i + j] != pieces[index][j]) {
                    return false;
                }
            }
            i += length;
        }
        return true;
    }
}
