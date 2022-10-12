package com.hermes.algorithm.binarytree;

/**
 * 修剪二叉搜索树
 *
 * @author liu.zongbin
 * @since 2022/10/12
 */
public class Question669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
    }
}
