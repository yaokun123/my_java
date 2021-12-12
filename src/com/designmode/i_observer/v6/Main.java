package com.designmode.i_observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义事件类，根据事件不同特殊处理
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
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");
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
// 事件类
class wakeUpEvent{
    long timestamp;
    String loc;

    public wakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }
}

public class Main {

    public static void main(String[] args){
        Child c = new Child();

        // do sth
        c.wakeUp();
    }
}
