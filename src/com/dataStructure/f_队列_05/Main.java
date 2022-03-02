package com.dataStructure.f_队列_05;

public class Main {

    public static void main(String[] args) {
        //// 测试单向队列
        Queue<Object> queue = new Queue<>();

        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);
        queue.enQueue(55);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }

        //// 测试双端队列
        System.out.println("==========双向队列===========");
        Deque<Integer> deque = new Deque<>();

        deque.enQueueFront(11);     // 队头入队
        deque.enQueueFront(22);

        deque.enQueueRear(33);      // 队尾入队
        deque.enQueueRear(44);
        // 22 11 33 44

        while (!deque.isEmpty()) {
            System.out.println(deque.deQueueFront());   // 队头出队
        }

    }
}
