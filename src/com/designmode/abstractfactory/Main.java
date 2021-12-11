package com.designmode.abstractfactory;

public class Main {
    public static void main(String[] args){
        /*Car c = new Car();
        c.go();

        AK47 w = new AK47();
        w.shoot();

        Bread b = new Bread();
        b.printName();*/

        //任意定义产品一族
        //抽象工厂
        AbstractFactory f = new ModernFactory();//如果想替换产品族，直接修改为如下即可
        //AbstractFactory f = new ModernFactory();

        Vehicle c = f.createVehicle();
        c.go();

        Weapon w = f.createWeapon();
        w.shoot();

        Food b = f.createFood();
        b.printName();

        /**
         * 工厂模式在产品纬度扩展比较方便
         * 抽象工厂模式在产品一族扩展比较方便
         *
         * 当使用接口和抽象类都可以时，一般是根据语义来决定
         * 形容词用接口，名词用抽象类
         */



    }
}
