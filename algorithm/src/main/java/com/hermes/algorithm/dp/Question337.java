package com.hermes.algorithm.dp;

import com.hermes.algorithm.binarytree.TreeNode;

/**
 * 打家劫舍3
 *
 * @author liu.zongbin
 * @since 2022/11/22
 */
public class Question337 {

    public int rob(TreeNode root) {
        // 0表示不偷节点，1表示偷节点
        int[] result = robTree(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robTree(TreeNode cur) {
        if (cur == null) {
            return new int[2];
        }
        // 左节点
        int[] left = robTree(cur.left);
        // 右节点
        int[] right = robTree(cur.right);
        // 不偷cur，可以偷或不偷左右节点，取较大的情况
        int val0 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷cur，就不能偷左右子节点
        int val1 = cur.val + left[0] + right[0];
        return new int[]{val0, val1};
    }

    public static void main(String[] args) {
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode b = new TreeNode(4, d, e);
        TreeNode f = new TreeNode(1);
        TreeNode c = new TreeNode(5, null, f);
        TreeNode a = new TreeNode(3, b, c);


        Question337 question337 = new Question337();
        System.out.println(question337.rob(a));
    }
}
