package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/9/13 20:16
 */
public class Question404 {

    public int sumOfLeftLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }
        int leftNum = sumOfLeftLeaves(node.left);
        if (node.left != null && node.left.left == null && node.left.right == null) {
            leftNum = node.left.val;
        }
        int rightNum = sumOfLeftLeaves(node.right);
        return leftNum + rightNum;
    }
}
