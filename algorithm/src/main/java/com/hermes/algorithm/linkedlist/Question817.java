package com.hermes.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liu.zongbin
 * @since 2022/10/12
 */
public class Question817 {

    /**
     * 输入: head = [0,1,2,3,4], nums = [0,3,1,4]
     * 输出: 2
     * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Question817 question817 = new Question817();
        ListNode d = new ListNode(4);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        ListNode head = new ListNode(0, a);
        System.out.println(question817.numComponents(head, new int[]{0, 3, 1, 4}));
    }
}
