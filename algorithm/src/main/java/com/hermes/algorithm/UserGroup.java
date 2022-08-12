package com.hermes.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户分组
 * leetcode题号1282
 *
 * @author liu.zongbin
 * @since 2022/8/12
 */
public class UserGroup {

    /**
     * 输入：groupSizes = [2,1,3,3,3,2]
     * 输出：[[1], [0,5], [2,3,4]]
     */
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] == 0) {
                continue;
            }
            List<Integer> group = new ArrayList<>();
            group.add(i);
            int size = groupSizes[i] - 1;
            for (int j = i + 1; j < groupSizes.length && size > 0; j++) {
                if (groupSizes[j] == groupSizes[i]) {
                    group.add(j);
                    groupSizes[j] = 0;
                    size--;
                }
            }
            result.add(group);
        }
        return result;
    }

    private static List<Integer> newGroup(int groupSize) {
        return new ArrayList<>(groupSize);
    }

    private static boolean isFull(List<Integer> group, int groupSize) {
        return group.size() == groupSize;
    }

    public static void main(String[] args) {
        int[] groupSizes = {2, 1, 3, 3, 3, 2};
        System.out.println(groupThePeople(groupSizes));
    }
}
