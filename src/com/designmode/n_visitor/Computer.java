package com.designmode.n_visitor;

// 访问者模式
public class Computer {
    /**
     * visitor模式访问的是结构固定的
     * 多数用在编译器上
     */
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor v){
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }

    public static void main(String[] args) {
        PersonVisitor p = new PersonVisitor();
        new Computer().accept(p);
        System.out.println(p.totalPrice);
    }

}

abstract class ComputerPart{
    abstract void accept(Visitor v);
    abstract double getPrice();
}

class CPU extends ComputerPart{
    @Override
    void accept(Visitor v) {
        v.visitorCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart{
    @Override
    void accept(Visitor v) {
        v.visitorMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart{
    @Override
    void accept(Visitor v) {
        v.visitorBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}


interface Visitor{
    void visitorCpu(CPU cpu);
    void visitorMemory(Memory memory);
    void visitorBoard(Board board);
}

class PersonVisitor implements Visitor{
    double totalPrice = 0.0;
    @Override
    public void visitorCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visitorMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.85;
    }

    @Override
    public void visitorBoard(Board board) {
        totalPrice += board.getPrice() * 0.95;
    }
}

class CorpVisitor implements Visitor{
    double totalPrice = 0.0;
    @Override
    public void visitorCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.6;
    }

    @Override
    public void visitorMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.75;
    }

    @Override
    public void visitorBoard(Board board) {
        totalPrice += board.getPrice() * 0.75;
    }
}