package com.hermes.algorithm.linkedlist;

/**
 * 删除链表倒数第N个节点
 * <a href="https://leetcode.cn/problems/SLwz0R/">https://leetcode.cn/problems/SLwz0R/</a>
 *
 * @author liu.zongbin
 * @since 2022/8/18 20:23
 */
public class RemoveNthFromEnd {

    /**
     * 快慢指针法：
     * 快指针先移动n+1步，然后快慢指针同时移动
     * <p>
     * dummyHead->5->4->3->2->1->null
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        int fastIndex = n + 1;
        while (fastIndex > 0) {
            fast = fast.next;
            fastIndex--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummyHead.next;
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

        System.out.println(removeNthFromEnd(node1, 1));
    }
}
