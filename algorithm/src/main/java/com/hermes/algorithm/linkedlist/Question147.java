package com.hermes.algorithm.linkedlist;

/**
 * 对链表进行插入排序
 *
 * @author liu.zongbin
 * @since 2022/11/9
 */
public class Question147 {

    /**
     * 1. 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 2. 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 3. 重复直到所有输入数据插入完为止。
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 已排序链表的尾结点
        ListNode sortedLast = head;
        // 待插入的元素
        ListNode cur = head.next;
        while (cur != null) {
            if (sortedLast.val <= cur.val) {
                // 顺序是对的，sortedLast前进一步
                sortedLast = sortedLast.next;
            } else {
                // 顺序不对，遍历链表，寻找插入curr的位置。
                ListNode pre = dummyHead;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                sortedLast.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            // cur继续指向sortedLast.next
            cur = sortedLast.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        Question147 question147 = new Question147();
        System.out.println(question147.insertionSortList(a));
    }
}