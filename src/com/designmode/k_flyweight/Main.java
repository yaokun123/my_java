package com.designmode.k_flyweight;

/**
 * 享元模式，重复利用对象-使用对象池来减少重复对象的创建
 */
public class Main {
    public static void main(String[] args){
        String s1 = "abc";
        String s2 = "abc";

        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s1);
        System.out.println(s3.intern() == s4.intern());
    }
}
