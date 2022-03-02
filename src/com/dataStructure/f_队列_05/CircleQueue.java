package com.dataStructure.f_队列_05;

/**
 * 环形队列-数组实现
 * @param <E>
 */
public class CircleQueue<E> {
    private int front;//记录队头下标
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    //// 环形队列元素数量
    public int size() {
        return size;
    }

    //// 环形队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //// 入队
    public void enQueue(E element) {
        //如果队列满了要扩容
        ensureCapacity(size+1);

        elements[(front + size) % elements.length] = element;
        size++;
    }

    //// 出队
    public E deQueue() {
        //如果队列没有元素了
        if(size == 0) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        E old = elements[front];
        elements[front] = null;

        front = (front+1) % elements.length;
        size--;

        //如果删除之后队列为空,front回到0
        if(size == 0) {
            front = 0;
        }
        return old;
    }

    public E front() {
        return elements[front];
    }

    //// 环形队列的扩容
    private void ensureCapacity(int capacity) {//保证要有capacity容量
        int oldCapacity = elements.length;//数组的容量
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);//1.5倍
        E[] newElements = (E[]) new Object[newCapacity];
        for(int i = 0;i<size;i++) {
            newElements[i] = elements[(i + front) % elements.length];
        }
        elements = newElements;

        //重置front
        front = 0;
        System.out.println(oldCapacity + "扩容成功为：" + newCapacity);
    }
}
