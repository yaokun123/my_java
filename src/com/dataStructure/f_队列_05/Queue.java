package com.dataStructure.f_队列_05;

import com.dataStructure.d_链表_03.LinkList_Double;

/**
 * 队列-使用数组和链表都可以，优先使用双向链表，因为队列主要是往头尾操作元素
 * @param <E>
 */
public class Queue<E> {
    private LinkList_Double<E> list = new LinkList_Double<>();

    //// 队列元素个数
    public int size() {
        return list.size();
    }

    //// 队列是否为空
    public boolean isEmpty() {
        return list.isEmpaty();
    }

    //// 队尾插入
    public void enQueue(E element) {
        list.add(element);
    }


    //// 队头弹出
    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}
