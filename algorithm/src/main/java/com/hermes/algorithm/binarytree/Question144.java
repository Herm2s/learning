package com.hermes.algorithm.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树前序遍历：中左右
 *
 * @author liu.zongbin
 * @since 2022/9/6 20:51
 */
public class Question144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        stack(root, result);
        return result;
    }

    /**
     * 迭代解法
     */
    public static void foreach(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
    }

    /**
     * 递归解法
     */
    public static void stack(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        stack(node.left, result);
        stack(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode left2 = new TreeNode(3);
        TreeNode right1 = new TreeNode(2, left2, null);
        TreeNode root = new TreeNode(1, null, right1);
        System.out.println(preorderTraversal(root));
    }
}
