package com.hermes.algorithm.binarytree;

/**
 * 把二叉搜索树转换为累加树
 *
 * @author herm2s
 * @since 2022/10/17 20:53
 */
public class Question538 {

    int pre = 0;

    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        // 右中左
        traversal(cur.right);
        cur.val += pre;
        pre = cur.val;
        traversal(cur.left);
    }
}
