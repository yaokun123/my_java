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


        //// 测试单链表-虚拟头节点
        System.out.println("============使用虚拟头节点的链表============");
        LinkList_VirtualHeadNode<Object> list2 = new LinkList_VirtualHeadNode<>();
        list2.add(1);
        System.out.println("判断元素是否存在：" + list2.indexOf(null));
        list2.add(null);
        System.out.println("判断元素是否存在：" + list2.indexOf(null));


        list2.add("test1");
        list2.add(121);
        list2.add(1111);
        list2.add(0,"hahaha");

        System.out.println(list2);

        list2.remove(1);
        System.out.println(list2);

        list2.clear();
        list2.add("test");
        System.out.println(list2);
    }
}
