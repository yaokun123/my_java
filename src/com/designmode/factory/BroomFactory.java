package com.designmode.factory;

public class BroomFactory implements Factory{
    public Broom create(){
        System.out.println("a broom created");
        return new Broom();
    }
}
