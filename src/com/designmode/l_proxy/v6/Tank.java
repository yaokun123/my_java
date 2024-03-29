package com.designmode.l_proxy.v6;

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
        new TankTimeProxy(new Tank()).move();
    }
}

// 时间代理
class TankTimeProxy implements Movable{
    Tank tank;//只能代理Tank

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }
}

// 日志代理
class TankLogProxy implements Movable{
    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("start moving...");
        tank.move();
        System.out.println("stoped!");
    }
}


interface Movable{
    void move();
}
