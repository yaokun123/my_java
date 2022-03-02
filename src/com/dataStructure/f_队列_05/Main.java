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
    }
}
