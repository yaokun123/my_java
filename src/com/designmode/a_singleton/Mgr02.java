package com.designmode.a_singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class Mgr02 {
    private static Mgr02 INSTANCE;

    private Mgr02(){}

    public static Mgr02 getInstance(){
        if(INSTANCE == null){
            try{//调试线程不安全问题
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public static void main(String[] args){
        for(int i = 0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr02.getInstance().hashCode());
            }).start();
        }
    }
}
