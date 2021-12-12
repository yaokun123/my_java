package com.designmode.b_strategy;

public class Cat implements Comparable{
    int weight, height;

    public Cat(int weight,int height){
        this.weight = weight;
        this.height = height;
    }

    //定义对象比较大小的方法
    public int compareTo(Object o){
        //如果不使用泛型这里还要强转一下
        //那如果这里传来的不是Cat的对象，这里进行强制转换的时候就会有问题
        //所以可以采用泛型的写法来优化
        Cat c = (Cat) o;
        if (this.weight < c.weight){
            return -1;
        }else if(this.weight > c.weight){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
