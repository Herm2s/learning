package com.hermes.algorithm.linkedlist;

/**
 * 反转链表
 *
 * @author liu.zongbin
 * @since 2022/8/17 20:50
 */
public class Question206 {

    /**
     * 双指针法
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmpCur = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmpCur;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(reverseList(node1));
    }
}
