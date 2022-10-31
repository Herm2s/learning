package com.hermes.algorithm.binarytree;

/**
 * 二叉树的直径
 *
 * @author liu.zongbin
 * @since 2022/10/28
 */
public class Question543 {

    private int result;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return result;
    }

    int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        result = Math.max(result, l + r);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;

        Question543 question543 = new Question543();
        System.out.println(question543.diameterOfBinaryTree(root));
    }
}
