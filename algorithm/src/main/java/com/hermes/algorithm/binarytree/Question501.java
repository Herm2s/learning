package com.hermes.algorithm.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author herm2s
 * @since 2022/10/1 13:45
 */
public class Question501 {

    TreeNode pre = null;

    int count = 0;

    int maxCount = 0;

    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Question501 question501 = new Question501();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        a.right = b;
        b.left = c;
        System.out.println(Arrays.toString(question501.findMode(a)));
    }

    public int[] findMode(TreeNode root) {
        traversal(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        if (pre == null) {
            count = 1;
        } else if (cur.val == pre.val) {
            count++;
        } else {
            count = 1;
        }
        pre = cur;
        if (count == maxCount) {
            result.add(cur.val);
        }
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(cur.val);
        }
        traversal(cur.right);
    }
}
