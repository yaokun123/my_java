package com.dataStructure.f_队列_05;

import com.dataStructure.d_链表_03.LinkList_Double;

/**
 * 双端队列
 * @param <E>
 */
public class Deque<E> {
    private LinkList_Double<E> list = new LinkList_Double<>();

    //// 双端队列元素个数
    public int size() {
        return list.size();
    }

    //// 判断双端队列是否为空
    public boolean isEmpty() {
        return list.isEmpaty();
    }

    //// 队尾入队
    public void enQueueRear(E element) {
        list.add(element);
    }

    //// 队头出队
    public E deQueueFront() {
        return list.remove(0);
    }

    //// 队头入队
    public void enQueueFront(E element) {
        list.add(0, element);
    }

    //// 队尾出队
    public E deQueueRear() {
        return list.remove(list.size()-1);
    }

    //// 获取队头元素
    public E front() {
        return list.get(0);
    }

    //// 获取队尾元素
    public E rear() {
        return list.get(list.size()-1);
    }
}
