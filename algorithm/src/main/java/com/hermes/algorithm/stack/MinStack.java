package com.hermes.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 *
 * @author liu.zongbin
 * @since 2022/11/10
 */
public class MinStack {

    /**
     * 保存所有元素
     */
    private Deque<Integer> stack;

    /**
     * 保存最小的元素
     */
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
