package com.hermes.algorithm.linkedlist;

/**
 * 环形链表二
 *
 * @author liu.zongbin
 * @since 2022/8/19 21:11
 */
public class Question142 {

    /**
     * 快慢指针法，快指针一次走两步，慢指针一次走一步，
     * 只要链表存在环形，快慢指针必定相遇
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
