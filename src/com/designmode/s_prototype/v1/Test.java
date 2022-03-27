package com.designmode.s_prototype.v1;

/**
 * 浅克隆
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();

        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);   // 浅拷贝
        p1.loc.street = "sh";
        System.out.println(p2.loc);
    }
}

class Person implements java.lang.Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location("bj", 22);

    @Override
    public Object clone() throws  CloneNotSupportedException{
        return super.clone();
    }
}

class Location{
    String street;
    int roomNo;

    public String toString(){
        return "Location{" +
                "street='" + street + '\'' +
                ",roomNo=" + roomNo +
                '}';
    }
    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
