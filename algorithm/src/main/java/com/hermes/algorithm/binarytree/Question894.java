package com.hermes.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu.zongbin
 * @date 2024/4/2
 */
public class Question894 {

    public static List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> process = process(n);
        return process;
    }

    private static List<TreeNode> process(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        // 真二叉树的总结点必为奇数
        if (n % 2 == 0) {
            return res;
        }
        // 遍历只处理奇数
        for (int i = 1; i < n; i += 2) {
            // 由于节点和为n，左子树节点为i时，右子树节点=n-i-1，1为根节点
            List<TreeNode> left = process(i);
            List<TreeNode> right = process(n - i - 1);
            // 分别枚举不同的左子树的根节点与右子树的根节点，从而可以构造出真二叉树的根节点
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(0, l, r);
                    res.add(node);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Question894.allPossibleFBT(5);
    }
}
