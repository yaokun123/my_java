package com.designmode.g_decorator;

/**
 * 装饰器模式
 *
 * 如果使用继承，需要装饰的太多的话会导致类爆炸，使用装饰器模式可以解决这一问题
 * 这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
 *
 * https://www.runoob.com/design-pattern/decorator-pattern.html
 */
public class Main {
    public static void main(String[] args){
        Shape circle = new Circle();

        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red and yellow border");
        ShapeDecorator yellow_read_rectangle = new YellowShapeDecorator(redRectangle);
        yellow_read_rectangle.draw();
    }
}
