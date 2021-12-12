package com.designmode.f_mediator;

import java.util.Date;

//创建中介类
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
