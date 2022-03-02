package com.dataStructure.a_leetcode_00.队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class _232_用栈实现队列 {

    //思路就是使用两个栈
    //1、入队时，push到inStack中
    //2、出队时，判断outStack是否为空，
    //如果为空则将inStack所有元素逐一弹出,push到outStack中，outStack弹出栈顶元素
    //如果不为空，outStack弹出栈顶元素
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    // 入队
    public void push(int x) {
        inStack.push(x);
    }

    // 出队
    public int pop() {
        if(outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    // 获取对头元素
    public int peek() {
        if(outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());

            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
