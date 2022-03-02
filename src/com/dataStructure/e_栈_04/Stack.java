package com.dataStructure.e_栈_04;

import com.dataStructure.c_动态数组_02.ArrayList2;
import com.dataStructure.d_链表_03.LinkList;

/**
 * 栈-使用数组和链表都可以
 * @param <E>
 */
public class Stack<E> {
    // 使用链表实现
    //private LinkList<E> list = new LinkList<>();

    // 使用数组实现
    private ArrayList2<E> list = new ArrayList2<>();

    //// 栈元素数量
    public int size() {
        return list.size();
    }

    //// 栈是否为空
    public boolean isEmpty() {
        return list.isEmpaty();
    }

    //// 入栈
    public void push(E element) {
        list.add(element);
    }

    //// 出栈
    public E pop() {
        return list.remove(list.size()-1);
    }

    //// 看一下栈顶元素
    public E top() {
        return list.get(list.size()-1);
    }
}
