package com.wen.thread;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        ExecutorService ex= Executors.newCachedThreadPool();
        final Semaphore sm=new Semaphore(3);
        for(int i=1;i<=10;i++){
            Runnable runnable=new Runnable() {
                public void run() {
                    try {
                        sm.acquire();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"进入，当前已经有并发"+(3-sm.availablePermits()));
                    try{
                        Thread.sleep((long)Math.random()*10000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    sm.release();
                    System.out.println("线程"+Thread.currentThread().getName()+"即将离开");

                    System.out.println("线程"+Thread.currentThread().getName()+"已经离开,当前已经有并发"+(3-sm.availablePermits()));
                }
            };
            ex.execute(runnable);
          //  new Thread(runnable).start();

        }
        ex.shutdown();
    }
}
