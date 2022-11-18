package com.hermes.algorithm.linkedlist;

/**
 * 反转链表2
 *
 * @author liu.zongbin
 * @since 2022/11/17
 */
public class Question92 {

    /**
     * 遍历两次
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        // 1 -> 5 -> 4 -> 3 -> 2 -> 6
        ListNode dummyHead = new ListNode(-1, head);

        ListNode pre = dummyHead;
        // 找到left的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        // 找到right节点
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 截取并切断链表
        ListNode leftNode = pre.next;
        ListNode tail = rightNode.next;
        pre.next = null;
        rightNode.next = null;

        // 反转链表子区间
        reverse(leftNode);

        // 拼接回链表(注意反转)
        pre.next = rightNode;
        leftNode.next = tail;

        return dummyHead.next;
    }

    private void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    /**
     * 一次遍历
     * 头插法
     * 在需要反转的区间里，每遍历到一个节点，将这个节点插入反转部分的起始位置。
     */
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        // 1 -> 5 -> 4 -> 3 -> 2 -> 6
        ListNode dummyHead = new ListNode(-1, head);
        // pre指向反转区间的前一个节点
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // cur指向反转区间的节点
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            // next指向反转区间节点的下一个节点
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        Question92 question92 = new Question92();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        ListNode listNode = question92.reverseBetween1(a, 2, 5);
        System.out.println(listNode);
    }
}
