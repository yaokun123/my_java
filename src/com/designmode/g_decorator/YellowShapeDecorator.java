package com.designmode.g_decorator;

public class YellowShapeDecorator extends ShapeDecorator{
    public YellowShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Border Color: Yellow");
    }
}
