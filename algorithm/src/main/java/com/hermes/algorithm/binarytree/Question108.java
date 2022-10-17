package com.hermes.algorithm.binarytree;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author herm2s
 * @since 2022/10/12 20:54
 */
public class Question108 {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
