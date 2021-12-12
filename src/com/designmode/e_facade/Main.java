package com.designmode.e_facade;

/**
 * 门面模式（外观模式）
 *
 * 统一一个对外的接待员，来协调外部于多个内部之间的复杂关系
 * 隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。
 *
 * 缺点：不符合开闭原则，如果要改东西很麻烦
 *
 *https://www.runoob.com/w3cnote/facade-pattern-3.html
 */
public class Main {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
