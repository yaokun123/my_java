package com.designmode.proxy.v7;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 *
 * 问题2：如果无法改变方法源码呢？
 * 使用继承？
 *
 * 还是使用代理吧
 *
 * 代理有各种类型
 *
 * 问题：如何实现代理的各种组合？
 *
 * 代理的对象改为Movable类型，越来越像decorator了
 */
public class Tank implements Movable{

    // 模拟坦克移动了一段时间
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        //new TankTimeProxy(new Tank()).move();
        new TankTimeProxy(
                new TankLogProxy(
                        new Tank()
                )
        ).move();
    }
}

// 时间代理
class TankTimeProxy implements Movable{
    Movable m;//修改为Movable

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public TankTimeProxy(Movable m) {
        this.m = m;
    }
}

// 日志代理
class TankLogProxy implements Movable{
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving...");
        m.move();
        System.out.println("stoped!");
    }
}


interface Movable{
    void move();
}
