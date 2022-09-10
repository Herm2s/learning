package com.hermes.algorithm.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liu.zongbin
 * @since 2022/9/10
 */
public class Question257 {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        traversal(result, new LinkedList<>(), root);
        return result;
    }

    void traversal(List<String> result, Deque<String> path, TreeNode node) {
        // 先添加根节点
        path.add(String.valueOf(node.val));
        // 左右子节点都为空，说明收集完毕，返回
        if (node.left == null && node.right == null) {
            result.add(String.join("->", path));
            return;
        }
        // 收集左子节点
        if (node.left != null) {
            traversal(result, path, node.left);
            // 回溯，每次递归收集完自己的元素后都应该移除掉，回到根节点继续往别的子节点搜索
            path.removeLast();
        }
        // 收集右子节点
        if (node.right != null) {
            traversal(result, path, node.right);
            // 回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {

    }

    public class TreeNode {
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
