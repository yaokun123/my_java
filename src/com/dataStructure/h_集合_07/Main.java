package com.dataStructure.h_集合_07;

public class Main {
    public static void main(String[] args) {
        Set<Integer> listSet = new ListSet<>();

        listSet.add(10);
        listSet.add(11);
        listSet.add(11);
        listSet.add(12);
        listSet.add(10);
        System.out.println("size of:" + listSet.size());

        listSet.traversal(new Set.Visitor<Integer>() {

            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
