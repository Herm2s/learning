package com.hermes.algorithm.linkedlist;


/**
 * 移除链表元素
 *
 * @author liu.zongbin
 * @since 2022/8/15 20:48
 */
public class Question203 {

    /**
     * 传统解法
     */
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            // 删除头节点
            head = head.next;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 虚拟头节点解法
     */
    public static ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(2, node3);
        ListNode node5 = new ListNode(2, node4);
        ListNode node6 = new ListNode(2, node5);
        ListNode node7 = new ListNode(2, node6);
        System.out.println(removeElements1(node7, 1));

    }
}

