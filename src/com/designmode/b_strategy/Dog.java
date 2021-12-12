package com.designmode.b_strategy;

public class Dog implements Comparable<Dog>{//这里使用泛型，没有使用泛型的例子参考Cat类
    int food;

    //如果Dog有多种比较大小的方法又咋办？参考Tiger类
    public int compareTo(Dog d){//Object o
        //如果不使用泛型这里还要强转一下
        //那如果这里传来的不是Dog的对象，这里进行强制转换的时候就会有问题
        //所以可以采用泛型的写法来优化
        //Dog d = (Dog) o;
        if(this.food < d.food){
            return -1;
        }else if(this.food > d.food){
            return 1;
        }else{
            return 0;
        }
    }
    public Dog(int food){
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
