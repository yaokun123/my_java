package com.designmode.observer.v4;

/**
 * 加入多个观察者
 */
class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mom mom = new Mom();
    private Dog dog = new Dog();

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        dad.feed();
        mom.hug();
        dog.wang();

    }
}
class Dad{
    public void feed(){
        System.out.print("dad feeding......");
    }
}

class Mom{
    public void hug(){
        System.out.print("mom hugging......");
    }
}

class Dog{
    public void wang(){
        System.out.print("mom wang......");
    }
}

public class Main {
    public static void main(String[] args){
        Child c = new Child();

        // do sth
        c.wakeUp();
    }
}
