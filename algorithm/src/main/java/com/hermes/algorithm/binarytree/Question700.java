package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/9/24 11:05
 */
public class Question700 {

    public static void main(String[] args) {

    }

    /**
     * 递归法
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    /**
     * 迭代法
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                break;
            }
            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    class TreeNode {
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
