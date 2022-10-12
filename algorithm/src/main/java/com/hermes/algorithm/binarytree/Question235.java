package com.hermes.algorithm.binarytree;

/**
 * @author liu.zongbin
 * @since 2022/10/9
 */
public class Question235 {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // p和q在左子树
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // p和q在右子树
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 找到最近祖先
        else {
            return root;
        }
    }
}
