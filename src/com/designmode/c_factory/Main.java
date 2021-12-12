package com.designmode.c_factory;

public class Main {
    public static void main(String[] args){
        /*Car c = new Car();
        c.go();*/

        /*Plane p = new Plane();
        p.go();*/

        //任意定制交通工具(实现Moveable即可)
        //Moveable m = new Plane();
        //m.go();

        //任意定制生产过程(使用简单工厂-可扩展性不好)
        //Moveable m = new SimpleVehicleFactory().createCar();
        //Moveable m = new SimpleVehicleFactory().createPlane();
        //Moveable m = new SimpleVehicleFactory().createBroom();
        //m.go();

        //任意定制生产过程(使用工厂方法，使用不同的xxxFactory.create())
        //Moveable m = new CarFactory().create();
        //Moveable m = new PlaneFactory().create();
        Moveable m = new BroomFactory().create();
        m.go();


    }
}
