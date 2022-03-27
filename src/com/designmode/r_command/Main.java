package com.designmode.r_command;

/**
 * 命令模式-将请求封装成命令，并记录下来，能够撤销与重做
 */
public class Main {
    public static void main(String[] args) {
        Content c = new Content();

        Command insertCommand = new InsertCommand(c);
        insertCommand.doit();
        insertCommand.undo();

        Command copyCommand = new CopyCommand(c);
        copyCommand.doit();
        copyCommand.undo();

        Command deletedCommand = new DeletedCommand(c);
        deletedCommand.doit();
        deletedCommand.undo();

        System.out.println(c.msg);
    }
}
