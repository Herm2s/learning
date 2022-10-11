package com.hermes.algorithm.binarytree;

/**
 * 删除二叉搜索树中的节点
 *
 * @author liu.zongbin
 * @since 2022/10/11
 */
public class Question450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        // 情况1，没找到要删除的节点，返回
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            // 情况2，目标节点左右孩子都为空
            if (root.left == null && root.right == null) {
                return null;
            }
            // 情况3，目标节点左孩子为空，右孩子不为空
            if (root.left == null) {
                return root.right;
            }
            // 情况4，目标节点左孩子不为空，右孩子为空
            if (root.right == null) {
                return root.left;
            }
            // 情况5，目标节点左右孩子都不为空
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = root.left;
            root = root.right;
            return root;
        }
        // 递归寻找左右子节点
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }


    public static void main(String[] args) {

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
