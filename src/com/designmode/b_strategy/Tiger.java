package com.designmode.b_strategy;

public class Tiger {
    int food;

    public Tiger(int food){
        this.food = food;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "food=" + food +
                '}';
    }
}
