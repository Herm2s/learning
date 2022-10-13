package com.hermes.algorithm.linkedlist;

/**
 * @author liu.zongbin
 * @since 2022/9/28
 */
public class Question141 {

    public static void main(String[] args) {
        Question141 question141 = new Question141();
        System.out.println(question141.hasCycle(new ListNode(1)));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 3 2 0 4 2
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
