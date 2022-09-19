package com.hermes.algorithm.binarytree;

import java.util.Arrays;

/**
 * @author liu.zongbin
 * @since 2022/9/19 20:03
 */
public class Question654 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 2, 1)));
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        // 中
        int maxValue = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        if (index > 0) {
            // 左
            int[] left = Arrays.copyOfRange(nums, 0, index);
            root.left = constructMaximumBinaryTree(left);
        }
        if (index < nums.length - 1) {
            // 右
            int[] right = Arrays.copyOfRange(nums, index + 1, nums.length);
            root.right = constructMaximumBinaryTree(right);
        }
        return root;
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
