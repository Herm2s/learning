package com.hermes.algorithm.binarytree;

/**
 * 完全二叉树的节点个数
 *
 * @author liu.zongbin
 * @since 2022/9/9 12:10
 */
public class Question222 {

    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        return getNode1(root);
    }

    /**
     * 普通二叉树遍历解法
     */
    int getNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftNum = getNode(node.left);
        int rightNum = getNode(node.right);
        return 1 + leftNum + rightNum;
    }

    /**
     * 完全二叉树解法
     */
    int getNode1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }
        int leftNum = getNode1(node.left);
        int rightNum = getNode1(node.right);
        return leftNum + rightNum + 1;
    }
}
