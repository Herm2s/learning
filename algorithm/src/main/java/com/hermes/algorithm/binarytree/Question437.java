package com.hermes.algorithm.binarytree;

/**
 * 路径总和III
 *
 * @author liu.zongbin
 * @since 2022/10/20
 */
public class Question437 {

    int result = 0;

    /**
     * 前序遍历每个节点，然后以每个节点作为起始递归查找所有路径
     */
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        subPathSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return result;
    }

    private void subPathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        if (targetSum == 0) {
            result++;
        }
        subPathSum(root.left, targetSum);
        subPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(-2);
        TreeNode h = new TreeNode(1);
        TreeNode i = new TreeNode(11);
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        d.left = f;
        d.right = g;
        e.right = h;
        c.right = i;

        Question437 question437 = new Question437();
        System.out.println(question437.pathSum(root, 8));
    }
}
