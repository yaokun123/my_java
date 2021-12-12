package com.designmode.i_observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与被观察者
 */
class Child{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
    }

    public void wakeUp(){
        cry = true;
        for(Observer o : observers){
            o.actionOnWakeUp();
        }
    }
}
interface Observer{
    void actionOnWakeUp();
}
class Dad implements Observer{
    @Override
    public void actionOnWakeUp() {
        feed();
    }
    public void feed(){
        System.out.println("dad feeding......");
    }
}

class Mom implements Observer{
    @Override
    public void actionOnWakeUp() {
        hug();
    }
    public void hug(){
        System.out.println("mom hugging......");
    }
}

class Dog implements Observer{
    @Override
    public void actionOnWakeUp() {
        wang();
    }
    public void wang(){
        System.out.println("mom wang......");
    }
}
public class Main {
    public static void main(String[] args){
        Child c = new Child();

        // do sth
        c.wakeUp();
    }
}
