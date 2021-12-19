package com.designmode.m_iterator.v5;

public class LinkedList_ implements Collection_ {
    @Override
    public Iterator_ iterator() {
        return null;
    }

    Node head = null;
    Node tail = null;

    // 目前容器中有多少个元素
    public int size = 0;


    public void add(Object o){
        Node n = new Node(o);
        n.next = null;
        if(head == null){
            head = n;
            tail = n;
        }
        tail.next = n;
        tail = n;
        size++;
    }
    public int size(){
        return size;
    }

    private class Node{
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

}
