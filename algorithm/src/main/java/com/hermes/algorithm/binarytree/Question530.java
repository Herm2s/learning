package com.hermes.algorithm.binarytree;

/**
 * @author herm2s
 * @since 2022/9/28 20:27
 */
public class Question530 {

    int result = Integer.MAX_VALUE;

    TreeNode pre = null;

    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (pre != null) {
            result = Math.min(Math.abs(pre.val - cur.val), result);
        }
        pre = cur;
        traversal(cur.right);
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
