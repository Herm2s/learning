package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/9/8 20:34
 */
public class Question226 {

    public class TreeNode {
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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        swap(root.left, root.right, root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private static void swap(TreeNode left, TreeNode right, TreeNode root) {
        root.left = right;
        root.right = left;
    }

    public static void main(String[] args) {

    }
}
