package com.designmode.b_strategy;

import java.util.Arrays;

/**
 * 策略模式-封装不同的算法，算法之间能互相替换
 */
public class Main {
    public static void main(String[] args){
        //int[] a = {9,2,3,5,7,1,4};
        //Cat[]a = {new Cat(3,3),new Cat(5,5),new Cat(1,1)};
        //Dog[]a = {new Dog(3),new Dog(5),new Dog(1)};
        //Sorter sorter = new Sorter();
        Tiger[]a = {new Tiger(3),new Tiger(5),new Tiger(1)};
        Sorter2<Tiger> sorter = new Sorter2<>();
        sorter.sort(a,new TigerCompartor());//使用比较器模式方便扩展比较策略
        System.out.println(Arrays.toString(a));
    }
}
