package com.hermes.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu.zongbin
 * @created 2022/7/1 15:06
 */
public class LRUCacheDemo {

    private int cacheSize;

    Map<Integer, Node<Integer, Integer>> map;

    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCacheDemo(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList<>();
    }

    /**
     * 获取数据
     */
    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = this.map.get(key);
        // 先删除节点
        this.doubleLinkedList.removeNode(node);
        // 再移动到队头
        this.doubleLinkedList.addHead(node);
        return node.value;
    }

    /**
     * 放入数据
     */
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node<Integer, Integer> node = this.map.get(key);
            // 更新数据
            node.value = value;
            map.put(key, node);

            // 先删除节点
            this.doubleLinkedList.removeNode(node);
            // 再移动到队头
            this.doubleLinkedList.addHead(node);
        } else {
            if (this.map.size() == this.cacheSize) {
                Node<Integer, Integer> last = this.doubleLinkedList.getLast();
                this.map.remove(last.key);
                this.doubleLinkedList.removeNode(last);
            }
            Node<Integer, Integer> newNode = new Node<>(key, value);
            this.map.put(key, newNode);
            this.doubleLinkedList.addHead(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);

        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 2);
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(4, 1);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5, 1);
        System.out.println(lruCacheDemo.map.keySet());

    }
}

class DoubleLinkedList<K, V> {

    Node<K, V> head;
    Node<K, V> tail;

    public DoubleLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 添加到队头
     */
    public void addHead(Node<K, V> node) {
        // 注意这里是将节点添加到head的后面
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除节点
     */
    public void removeNode(Node<K, V> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

        node.prev = null;
        node.next = null;
    }

    /**
     * 获得最后一个节点
     */
    public Node<K, V> getLast() {
        return tail.prev;
    }
}

class Node<K, V> {
    K key;
    V value;

    Node<K, V> prev;
    Node<K, V> next;

    public Node() {
        this.prev = this.next = null;
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
}
