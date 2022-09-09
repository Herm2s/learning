package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/9/9 12:46
 */
public class Question110 {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        // 左子树不是平衡二叉树
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        // 右子树不是平衡二叉树
        if (rightHeight == -1) {
            return -1;
        }
        int result;
        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = -1;
        } else {
            result = Math.max(leftHeight, rightHeight) + 1;
        }
        return result;
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
