package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/9/9 11:57
 */
public class Question111 {

    public int minDepth(TreeNode root) {
        return getHeight(root);
    }

    int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        // 子树为null的高度不应该记录
        if (node.left == null && node.right != null) {
            return 1 + rightHeight;
        } else if (node.left != null && node.right == null) {
            return 1 + leftHeight;
        } else {
            return 1 + Math.min(leftHeight, rightHeight);
        }
    }

    public static void main(String[] args) {

    }
}
