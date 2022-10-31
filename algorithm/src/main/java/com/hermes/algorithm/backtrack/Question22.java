package com.hermes.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author liu.zongbin
 * @since 2022/10/31
 */
public class Question22 {

    private List<String> result = new ArrayList<>();

    private StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        // ()()()
        backtrack(n, 0, 0);
        return result;
    }

    void backtrack(int n, int left, int right) {
        // 收集结果
        if (path.length() == 2 * n) {
            result.add(path.toString());
            return;
        }
        if (left < n) {
            path.append("(");
            backtrack(n, left + 1, right);
            // 回溯
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(")");
            backtrack(n, left, right + 1);
            // 回溯
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        Question22 question22 = new Question22();
        System.out.println(question22.generateParenthesis(3));
    }
}
