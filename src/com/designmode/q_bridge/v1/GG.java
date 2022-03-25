package com.designmode.q_bridge.v1;

/**
 * 桥接模式-将两个能够独立变化的部分分离开来
 */
public class GG {
    public void chase(MM mm){
        Gift g = new Book();
        give(mm,g);
    }
    public void give(MM mm, Gift g){}
}
class MM{
    String name;
}

abstract class Gift{}
class Book extends Gift{}
class Flower extends Gift{}