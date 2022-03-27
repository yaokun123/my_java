package com.designmode.s_prototype.v2;

/**
 * 深克隆
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();

        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);   // 深拷贝
        p1.loc.street = "sh";
        System.out.println(p2.loc);
    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location("bj", 22);

    @Override
    public Object clone() throws  CloneNotSupportedException{
        //return super.clone();

        // loc也克隆一份
        Person p = (Person) super.clone();
        p.loc = (Location)loc.clone();
        return p;
    }
}

class Location implements Cloneable{    // 让Location也实现Cloneable接口
    String street;
    int roomNo;

    public Object clone() throws  CloneNotSupportedException{
        return super.clone();
    }

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
