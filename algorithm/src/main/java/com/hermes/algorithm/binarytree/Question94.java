package com.hermes.algorithm.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中序遍历：左中右
 *
 * @author liu.zongbin
 * @since 2022/9/6 20:51
 */
public class Question94 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        stack(root, result);
        return result;
    }

    /**
     * 迭代解法
     */
    public static void foreach(TreeNode root, List<Integer> result) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
    }

    /**
     * 递归解法
     */
    public static void stack(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        stack(node.left, result);
        result.add(node.val);
        stack(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode left2 = new TreeNode(3);
        TreeNode right1 = new TreeNode(2, left2, null);
        TreeNode root = new TreeNode(1, null, right1);
        System.out.println(preorderTraversal(root));
    }

    static class TreeNode {

        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
