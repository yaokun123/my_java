package com.designmode.m_iterator.v4;

/**
 * v1:构建一个容器可以添加对象
 * v2:用链表来实现一个容器
 * v3:添加容器的共同接口，实现容器的替换
 * v4:如何对容器遍历呢？
 */
public class Main {
    public static void main(String[] args){
        //Collection_ list = new LinkedList_();
        Collection_ list = new ArrayList_();
        for (int i=0;i<15;i++){
            list.add(new String("s" + i));
        }
        System.out.println(list.size());

        ArrayList_ al = (ArrayList_) list;
        for (int i = 0;i<list.size();i++){
            // 如果使用这种遍历方式，就不能实现通用了
        }
    }
}
