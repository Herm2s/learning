package com.hermes.algorithm.binarytree;

import java.util.Arrays;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author liu.zongbin
 * @since 2022/9/16 21:23
 */
public class Question106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length == 1) {
            return root;
        }

        for (int i = 0; i < inorder.length; i++) {
            // 用根节点的值去中序数组中查找对应元素下标
            if (postorder[postorder.length - 1] == inorder[i]) {
                // 找出中序遍历的左子树和右子树
                int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                // 找出后序遍历的左子树和右子树
                int[] postorderLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postorderRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                // 递归遍历左子树
                root.left = buildTree(inorderLeft, postorderLeft);
                // 递归遍历右子树
                root.right = buildTree(inorderRight, postorderRight);
                break;
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
