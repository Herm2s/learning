package com.hermes.algorithm.stack;

import java.util.Stack;

/**
 * @author liu.zongbin
 * @since 2022/8/31 21:24
 */
public class Question232 {

    class MyQueue {

        /**
         * 入栈
         * 入口->2->1->0
         */
        private Stack<Integer> inStack;
        /**
         * 出栈
         * 0->1->2->出口
         */
        private Stack<Integer> outStack;

        public MyQueue() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        public void push(int x) {
            this.inStack.push(x);
            this.dumpStackIn();
        }

        public int pop() {
            this.dumpStackIn();
            return this.outStack.pop();
        }

        public int peek() {
            this.dumpStackIn();
            return this.outStack.peek();
        }

        public boolean empty() {
            return this.outStack.isEmpty() && this.inStack.isEmpty();
        }

        // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
        private void dumpStackIn() {
            if (!outStack.isEmpty()) {
                return;
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
