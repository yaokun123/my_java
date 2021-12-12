package com.designmode.b_strategy;

public class TigerCompartor implements Comparator<Tiger>{
    @Override
    public int compare(Tiger o1, Tiger o2) {
        if(o1.food < o2.food){
            return -1;
        }else if(o1.food > o2.food){
            return 1;
        }else{
            return 0;
        }
    }
}
