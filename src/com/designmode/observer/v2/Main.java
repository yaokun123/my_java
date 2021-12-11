package com.designmode.observer.v2;

/**
 * 面向对象的傻等
 */
class Child {
    private boolean cry = false;

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.print("Waked Up!crying......");
        cry = true;
    }
}


public class Main{
    public static void main(String[] args){
        Child child = new Child();

        while (!child.isCry()){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.print("observing......");
        }
    }
}