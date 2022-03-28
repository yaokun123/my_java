package com.designmode.u_template;

/**
 * 模板模式-定义一套流程模板，根据需要实现模板中的操作
 * （钩子函数）
 *
 * 重写一个方法，系统帮我们自动调用
 */
public class Main {
    public static void main(String[] args) {
        F f = new C1();
        f.m();
    }
}

abstract class F{
    void m(){
        op1();
        op2();
    }
    abstract void op1();
    abstract void op2();
}

class C1 extends F{
    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}
