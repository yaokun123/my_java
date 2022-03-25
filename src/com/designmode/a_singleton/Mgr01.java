package com.designmode.a_singleton;

/**
 * 单例模式-保证一个类仅有一个实例，并且提供一个全局访问点
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全(每个class只会load到内存一次)
 * 简单实用，推荐使用
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * （话说你不用的，装载它干啥）
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){}

    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args){
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
