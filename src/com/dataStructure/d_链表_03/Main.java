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


        //// 测试双向链表
        System.out.println("===========双向链表============");
        LinkList_Double<Object> list3 = new LinkList_Double<>();
        list3.add(11);
        list3.add(22);
        list3.add(33);
        list3.add(44);
        list3.add(0,55);
        list3.add(2,66);

        System.out.println(list3);
        list3.remove(list3.size()-1);
        System.out.println(list3);


        System.out.println("===========单向循环链表============");
        LinkList_SingleCircle<Object> list4 = new LinkList_SingleCircle<>();


        list4.add(11);
        list4.add(22);
        list4.add(33);
        list4.add(44);
        list4.add(0,55);
        list4.add(2,66);


        System.out.println(list4);
        list4.remove(list4.size()-1);
        System.out.println(list4);
    }
}
