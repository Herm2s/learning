package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/9/14 20:30
 */
public class Question513 {

    int maxDepth = 0;

    int result;

    public int findBottomLeftValue(TreeNode root) {
        travel(root, 1);
        return result;
    }

    void travel(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = root.val;
            }
        }
        if (root.left != null) {
            depth++;
            travel(root.left, depth);
            // 回溯
            depth--;
        }
        if (root.right != null) {
            depth++;
            travel(root.right, depth);
            // 回溯
            depth--;
        }
    }

    public static void main(String[] args) {

    }

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

}
