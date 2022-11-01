package com.hermes.algorithm.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同的儿茶搜索树
 *
 * @author liu.zongbin
 * @since 2022/11/1
 */
public class Question96 {

    private Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            // 左子树可能的数量
            int left = numTrees(i - 1);
            // 右子树可能的数量
            int right = numTrees(n - i);
            count += left * right;
        }
        map.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        Question96 question96 = new Question96();
        System.out.println(question96.numTrees(3));
    }
}
