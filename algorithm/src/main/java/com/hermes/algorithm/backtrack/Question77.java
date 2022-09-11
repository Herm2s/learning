package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/9/11
 */
public class Question77 {

    private final List<List<Integer>> result = new ArrayList<>();

    private final LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return result;
    }

    void backTracking(int n, int k, int startIndex) {
        // path.size = k 的时候收集结果
        if (path.size() == k) {
            // 这里一定要new一个出来，深拷贝
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            // 回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {

    }
}
