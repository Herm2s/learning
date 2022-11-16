package com.hermes.algorithm.linkedlist;

/**
 * @author liu.zongbin
 * @since 2022/11/16
 */
public class Question82 {

    /**
     * 0 1 2 3 3 4 4 5
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {

            // 重复元素必是相邻的
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
