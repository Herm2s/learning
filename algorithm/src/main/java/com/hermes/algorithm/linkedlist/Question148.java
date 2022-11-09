package com.hermes.algorithm.linkedlist;

/**
 * 排序链表（归并排序）
 *
 * @author liu.zongbin
 * @since 2022/11/9
 */
public class Question148 {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    /**
     * 对链表自顶向下归并排序的过程如下。
     * 1. 找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动2步，慢指针每次移动1步，
     * 当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
     * 2. 对两个子链表分别排序。
     * 3. 将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并。
     */
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode head1 = sortList(head, mid);
        ListNode head2 = sortList(mid, tail);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (head1.val < head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        Question148 question148 = new Question148();
        System.out.println(question148.sortList(a));
    }
}
