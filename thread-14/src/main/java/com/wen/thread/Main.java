package com.wen.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static  void main(String[] args){
        ExecutorService ex= Executors.newCachedThreadPool();
        final CyclicBarrier cb=new CyclicBarrier(3);
        for (int i=0;i<3;i++){
           Runnable runnable= new Runnable(){

               public void run() {
                   try {
                       Thread.sleep((long)Math.random()*10000);
                       System.out.println("线程"+Thread.currentThread().getName()+"即将到达目的地1,当前有"+(cb.getNumberWaiting()));
                       cb.await();
                       Thread.sleep((long)Math.random()*10000);
                       System.out.println("线程"+Thread.currentThread().getName()+"即将到达目的地2,当前有"+(cb.getNumberWaiting()));
                       cb.await();
                       Thread.sleep((long)Math.random()*10000);
                       System.out.println("线程"+Thread.currentThread().getName()+"即将到达目的地3,当前有"+(cb.getNumberWaiting()));
                       cb.await();
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
           };
            ex.execute(runnable);
        }

        ex.shutdown();
    }
}
