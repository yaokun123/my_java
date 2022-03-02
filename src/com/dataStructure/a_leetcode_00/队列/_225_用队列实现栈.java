package com.dataStructure.a_leetcode_00.队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class _225_用队列实现栈 {
    private Deque<Integer> deque = new ArrayDeque<>();

    public void push(int x) {
        deque.addFirst(x);
    }

    public int pop() {
        return deque.removeFirst();
    }

    public int top() {
        return deque.element();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
