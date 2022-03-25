package com.designmode.q_bridge.v1;

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