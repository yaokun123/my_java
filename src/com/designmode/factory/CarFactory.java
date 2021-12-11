package com.designmode.factory;

public class CarFactory implements Factory{
    public Car create(){
        System.out.println("a car created");
        return new Car();
    }
}
