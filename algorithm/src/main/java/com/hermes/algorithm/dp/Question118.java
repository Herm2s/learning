package com.hermes.algorithm.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author liu.zongbin
 * @since 2022/12/1
 */
public class Question118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 两条边
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        Question118 question118 = new Question118();
        System.out.println(question118.generate(4));
    }
}
