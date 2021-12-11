package com.designmode.strategy;

/*public interface Comparable {
    int compareTo(Object o);
}*/

public interface Comparable<T> {//使用泛型
    int compareTo(T o);
}
