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
    }
}
