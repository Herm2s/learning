package com.hermes.algorithm.linkedlist;

/**
 * @author liu.zongbin
 * @since 2022/8/16 21:05
 */
public class Question707 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        // linkedList.addAtHead(1);
        // linkedList.addAtTail(3);
        // //链表变为1-> 2-> 3
        // linkedList.addAtIndex(1, 2);
        // //返回2
        // linkedList.get(1);
        // //现在链表是1-> 3
        // linkedList.deleteAtIndex(1);
        // //返回3
        // linkedList.get(1);
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        System.out.println(linkedList.get(0));
    }

}

/**
 * 0 -> 1 -> 2 -> 3
 */
class MyLinkedList {

    int size;

    /**
     * 虚拟头节点
     */
    ListNode head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode();
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode curNode = head;
        for (int i = 0; i <= index; i++) {
            curNode = curNode.next;
        }
        return curNode.val;
    }

    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        this.addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;

        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode nodeToAdd = new ListNode(val);
        nodeToAdd.next = pred.next;
        pred.next = nodeToAdd;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}
