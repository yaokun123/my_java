package com.designmode.singleton;
/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03(){}

    public static synchronized Mgr03 getInstance(){//锁定的是Mgr03.class对象
        if(INSTANCE == null){
            try{//调试线程不安全问题
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args){
        for(int i = 0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
