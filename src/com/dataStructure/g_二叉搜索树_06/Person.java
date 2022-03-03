package com.dataStructure.g_二叉搜索树_06;

public class Person implements Comparable<Person> {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return age - person.age;
    }
}
