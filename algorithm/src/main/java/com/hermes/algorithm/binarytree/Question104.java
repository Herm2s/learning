package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/9/8 21:10
 */
public class Question104 {

    public int maxDepth(TreeNode root) {
        return getHeight(root);
    }


    int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


