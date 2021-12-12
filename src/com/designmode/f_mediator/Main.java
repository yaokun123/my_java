package com.designmode.f_mediator;

/**
 * 调停者模式（中介者模式）
 *
 * 用来降低多个对象和类之间的通信复杂性，这种模式提供了一个中介类，
 * 该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。
 *
 * 缺点：中介者会庞大，变得复杂难以维护。
 * https://www.runoob.com/design-pattern/mediator-pattern.html
 */
public class Main {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
