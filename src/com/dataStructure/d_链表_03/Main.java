package com.dataStructure.d_链表_03;

public class Main {
    public static void main(String[] args) {

        //// 测试单链表
        LinkList<Object> list = new LinkList<>();

        list.add(1);
        list.add("test1");
        list.add(121);
        list.add(1111);
        list.add(0,"hahaha");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
