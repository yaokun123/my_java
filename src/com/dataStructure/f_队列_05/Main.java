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


        //// 测试环形队列
        System.out.println("==========环形队列===========");
        CircleQueue<Object> queue2 = new CircleQueue<>();
        for(int i = 0; i<10; i++) {         // 入队10个元素 0 1 2 3 4 5 6 7 8 9
            queue2.enQueue(i);
        }

        for(int i = 0;i<5; i++) {            // 出队5个元素 n n n n n 5 6 7 8 9
            queue2.deQueue();
        }


        for(int i = 15; i<23; i++) {        // 入队       15 16 17 18 19 20
                                            // 扩容       5 6 7 8 9 15 16 17 18 19 20 21 22
            queue2.enQueue(i);
        }

        //System.out.println(queue);
        while (!queue2.isEmpty()) {
            System.out.println(queue2.deQueue());// 出队

        }


        //// 测试循环双端队列
        System.out.println("==========循环双端队列===========");
        CircleDeque<Integer> cDeque = new CircleDeque<>();
        for(int i = 0;i<10;i++) {
            cDeque.enQueueFront(i+1);
            cDeque.enQueueRear(i + 100);
        }

        for(int i = 0;i<3;i++) {
            cDeque.deQueueFront();
            cDeque.deQueueRear();
        }

        cDeque.enQueueFront(11);
        cDeque.enQueueFront(22);

        while (!cDeque.isEmpty()) {
            System.out.println(cDeque.deQueueFront());

        }
    }
}
