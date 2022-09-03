package com.hermes.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author liu.zongbin
 * @since 2022/9/1 20:10
 */
public class Question225 {

   static class MyStack {

        private final Queue<Integer> queue;

        public MyStack() {
            this.queue = new ArrayDeque<>();
        }

        public void push(int x) {
            this.queue.add(x);
            this.reverseQueue();
        }

        public int pop() {
            return this.queue.poll();
        }

        public int top() {
            return this.queue.peek();
        }

        public boolean empty() {
            return this.queue.size() == 0;
        }

        private void reverseQueue() {
            int size = queue.size() - 1;
            while (size > 0) {
                Integer value = queue.poll();
                queue.add(value);
                size--;
            }
        }
    }

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        myStack.empty(); // 返回 False
    }
}
