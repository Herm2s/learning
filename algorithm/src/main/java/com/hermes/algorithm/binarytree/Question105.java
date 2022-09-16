package com.hermes.algorithm.binarytree;

import java.util.Arrays;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author liu.zongbin
 * @since 2022/9/16 21:23
 */
public class Question105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }

        for (int i = 0; i < inorder.length; i++) {
            // 用根节点的值去中序数组中查找对应元素下标
            if (preorder[0] == inorder[i]) {
                // 找出中序遍历的左子树和右子树
                int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                // 找出前序遍历的左子树和右子树
                int[] postorderLeft = Arrays.copyOfRange(preorder, 1, 1 + inorderLeft.length);
                int[] postorderRight = Arrays.copyOfRange(preorder, 1 + inorderLeft.length, preorder.length);
                // 递归遍历左子树
                root.left = buildTree(postorderLeft, inorderLeft);
                // 递归遍历右子树
                root.right = buildTree(postorderRight, inorderRight);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
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
