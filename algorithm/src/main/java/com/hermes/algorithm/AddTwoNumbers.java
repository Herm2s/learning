package main.java.com.hermes.algorithm;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author liuzongbin
 * @version 1.0
 * @date 2021/11/12
 */
class ListNode {

    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    /**
     * 整体思路：
     * 将长度较短的链表在末尾补零使得两个连表长度相等，再一个一个元素对其相加（考虑进位）
     * <p>
     * 1. 获取两个链表所对应的长度
     * 2. 在较短的链表末尾补零
     * 3. 对齐相加考虑进位
     * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针pre，该指针的下一个节点指向真正的头结点head。
     * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     */
    public ListNode addTowNumbers(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
        System.out.println(Integer.parseInt(" 21321 "));
    }
}
