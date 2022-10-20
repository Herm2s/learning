package com.hermes.algorithm.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/9/29
 */
public class Question114 {

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

    public void flatten1(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        flattenToList1(root, list);

        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void flattenToList1(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            flattenToList1(root.left, list);
            flattenToList1(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.right = f;

        Question114 question114 = new Question114();
        question114.flatten1(a);
    }
}
