package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/10/8
 */
public class Question236 {


    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归结束条件
        if (root == null || root == p || root == q) {
            return root;
        }
        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 未找到节点p或者节点q
        if (left == null && right == null) {
            return null;
        }
        // 若找到一个节点
        else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        }
        // 若找到两个节点
        else {
            return root;
        }
    }
}
