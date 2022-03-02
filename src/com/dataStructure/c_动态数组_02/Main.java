package com.dataStructure.c_动态数组_02;

public class Main {

    public static void main(String[] args) {

        // 测试动态数组-元素为int型
        ArrayList list = new ArrayList();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(33);
        list.add(33);
        //list.remove(1);
        list.add(1,111);
        list.add(1,111);
        System.out.println(list);


        //// 测试动态数组-元素类型为泛型
        ArrayList2<Integer> list2 = new ArrayList2<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println(list2);

        ArrayList2<String> list3 = new ArrayList2<>();
        list3.add("test1");
        list3.add("test2");
        list3.add("test3");
        System.out.println(list3);


        ArrayList2<Object> list4 = new ArrayList2<>();
        list4.add(1);
        list4.add("test1");
        System.out.println(list4);
    }
}
