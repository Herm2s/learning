package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/9/15 20:10
 */
public class Question112 {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        return traversal(root, targetSum);
    }

    boolean traversal(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val == targetSum;
        }
        return traversal(node.left, targetSum - node.val)
                || traversal(node.right, targetSum - node.val);
    }

    public static void main(String[] args) {

    }
}