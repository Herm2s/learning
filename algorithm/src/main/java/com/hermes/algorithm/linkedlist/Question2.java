package com.hermes.algorithm.linkedlist;

/**
 * 两数相加
 *
 * @author liu.zongbin
 * @since 2022/11/28
 */
public class Question2 {

    /**
     * 整体思路：
     * 将长度较短的链表在末尾补零使得两个连表长度相等，再一个一个元素对其相加（考虑进位）
     * <p>
     * 1. 获取两个链表所对应的长度
     * 2. 在较短的链表末尾补零
     * 3. 对齐相加考虑进位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // res存放结果，cur为链表的尾指针
        ListNode res = new ListNode(0);
        ListNode cur = res;
        // 表示进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 如果其中有一个到达结尾了，那么这个链表这一位的数字就为0
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            // 两个链表的两位相加
            int sum = a + b + carry;
            // 大于10则进位
            carry = sum > 9 ? 1 : 0;
            // 进位完剩下的余数
            sum = sum % 10;
            // 创建一个next接入res后面
            cur.next = new ListNode(sum);

            cur = cur.next;
            // 分别后移
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果最后还有进位的话，增加一个节点
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return res.next;
    }
}
