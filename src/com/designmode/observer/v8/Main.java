package com.designmode.observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 * 大多数时候，我们处理事件的时候，需要事件源对象
 *
 * 事件也可以形成继承体系
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
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed", this);
        for(Observer o : observers){
            o.actionOnWakeUp(event);
        }
    }
}
interface Observer{
    void actionOnWakeUp(wakeUpEvent event);
}
class Dad implements Observer {
    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        feed();
    }
    public void feed(){
        System.out.println("dad feeding......");
    }
}

class Mom implements Observer {
    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        hug();
    }
    public void hug(){
        System.out.println("mom hugging......");
    }
}

class Dog implements Observer {
    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        wang();
    }
    public void wang(){
        System.out.println("mom wang......");
    }
}
abstract class Event<T>{
    abstract T getSource();
}
// 事件类
class wakeUpEvent extends Event<Child>{
    long timestamp;
    String loc;
    Child source;// 增加一个事件源对象

    public wakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

public class Main {

    public static void main(String[] args){
        Child c = new Child();

        // do sth
        c.wakeUp();
    }
}
