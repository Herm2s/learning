package com.hermes.algorithm.linkedlist;

/**
 * @author liu.zongbin
 * @since 2022/10/27
 */
public class Question160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
}
