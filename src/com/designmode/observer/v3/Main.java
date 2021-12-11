package com.designmode.observer.v3;

/**
 * 加入观察者
 */

class Child {
    private boolean cry = false;
    private Dad d = new Dad();

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        d.feed();
    }
}

class Dad{
    public void feed(){
        System.out.print("dad feeding......");
    }
}

public class Main {
    public static void main(String[] args){
        Child child = new Child();
        // do sth
        child.wakeUp();
    }
}
