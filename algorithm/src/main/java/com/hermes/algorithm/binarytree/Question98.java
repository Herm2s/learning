package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/9/26
 */
public class Question98 {

    private long prevVal = Long.MIN_VALUE;

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        // 中序遍历，左中右
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= prevVal) {
            return false;
        }
        prevVal = root.val;
        return isValidBST(root.right);
    }
}
