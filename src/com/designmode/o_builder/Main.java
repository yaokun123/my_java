package com.designmode.o_builder;

/**
 * 构建者模式，用于构建复杂对象
 */
public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort().buildMine()
                .buildMine().build();

        Person p = new Person.PersonBuilder()
                .basicInfo(1,"zhangsan",18)
                .score(20)
                .weight(200)
                .loc("bj","23")
                .build();
    }
}
