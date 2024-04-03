package com.hermes.algorithm.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 找出克隆二叉树中的相同节点
 *
 * @author liu.zongbin
 * @date 2024/4/3
 */
public class Question1379 {

    /**
     * 深度优先
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }

    /**
     * 广度优先
     */
    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();
        q1.offer(original);
        q2.offer(cloned);

        while (!q1.isEmpty()) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if (t1 == target) {
                return t2;
            }

            if (t1.left != null) {
                q1.offer(t1.left);
                q2.offer(t2.left);
            }
            if (t1.right != null) {
                q1.offer(t1.right);
                q2.offer(t2.right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode original = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode three1 = new TreeNode(3);

        original.left = four;
        original.right = three;
        three.left = three1;
        three.right = new TreeNode(19);

        TreeNode cloned = new TreeNode(1);

        TreeNode four1 = new TreeNode(4);
        TreeNode three2 = new TreeNode(3);
        TreeNode three3 = new TreeNode(3);

        cloned.left = four1;
        cloned.right = three2;
        three2.left = three3;
        three2.right = new TreeNode(19);

        Question1379 question1379 = new Question1379();
        TreeNode targetCopy = question1379.getTargetCopy(original, cloned, three1);
        System.out.println(targetCopy);
    }
}
