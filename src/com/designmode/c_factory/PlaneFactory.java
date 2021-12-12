package com.designmode.c_factory;

public class PlaneFactory implements Factory{
    public Plane create(){
        System.out.println("a plane created");
        return new Plane();
    }
}
