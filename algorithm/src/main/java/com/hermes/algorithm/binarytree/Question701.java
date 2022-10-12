package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/10/10
 */
public class Question701 {

    public static void main(String[] args) {
        Question701 question701 = new Question701();
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        System.out.println(question701.insertIntoBST(root, 5));
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
