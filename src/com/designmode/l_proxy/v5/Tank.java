package com.designmode.l_proxy.v5;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 *
 * 问题2：如果无法改变方法源码呢？
 * 使用继承？
 *
 * 还是使用代理吧
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

// 使用代理
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


interface Movable{
    void move();
}
