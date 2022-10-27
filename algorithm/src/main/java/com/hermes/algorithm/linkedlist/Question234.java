package com.hermes.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 *
 * @author liu.zongbin
 * @since 2022/10/27
 */
public class Question234 {

    /**
     * 转为回文数组
     */
    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 递归
     */
    public boolean isPalindrome2(ListNode head) {
        headNode = head;
        return recursion(headNode);
    }

    private ListNode headNode;

    public boolean recursion(ListNode tailNode) {
        if (tailNode != null) {
            if (!recursion(tailNode.next)) {
                return false;
            }
            if (tailNode.val != headNode.val) {
                return false;
            }
            headNode = headNode.next;
        }
        return true;
    }

    /**
     * 反转后半部分链表
     */
    public boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfTail = endOfFirstHalf(head);
        ListNode secondHalfHead = reverseList(firstHalfTail.next);
        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原链表并返回结果
        firstHalfTail.next = reverseList(secondHalfHead);
        return result;
    }

    private ListNode reverseList(ListNode head) {
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

    /**
     * 慢指针一次走一步，快指针一次走两步，快慢指针同时出发。
     * 当快指针移动到链表的末尾时，慢指针恰好到链表的中间。
     */
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // 1 2 2 3 3 3 2 2 1
        Question234 question234 = new Question234();
    }
}
