package com.designmode.singleton;
/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04(){}

    public static Mgr04 getInstance(){
        if(INSTANCE == null){

            //妄图通过减小同步代码块的方式提高效率，然后不可行
            synchronized (Mgr04.class){
                try{//调试线程不安全问题
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                INSTANCE = new Mgr04();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args){
        for(int i = 0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
