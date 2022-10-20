package com.hermes.algorithm.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和II
 *
 * @author liu.zongbin
 * @since 2022/10/20
 */
public class Question113 {

    List<List<Integer>> result = new ArrayList<>();

    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        backtrack(root, targetSum);
        return result;
    }

    void backtrack(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }
        backtrack(root.left, targetSum);
        backtrack(root.right, targetSum);
        path.removeLast();
    }

    public static void main(String[] args) {
        Question113 question113 = new Question113();
        TreeNode root = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);
        root.left = b;
        root.right = c;
        b.left = d;
        d.left = g;
        d.right = h;
        c.left = e;
        c.right = f;
        f.left = i;
        f.right = j;
        System.out.println(question113.pathSum(root, 22));
    }
}
