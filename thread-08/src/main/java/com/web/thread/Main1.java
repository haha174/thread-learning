package com.web.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main1 {
    public static void main(String[] args){
        final ExecutorService threadPool=Executors.newCachedThreadPool();
        for (int i=1;i<=10;i++){
            final  int task=i;
            threadPool.execute(new Runnable() {
                public void run() {
                    for (int j=1;j<=10;j++){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" task id="+task+"  job id="+j);
                    }
                }
            });
        }
        System.out.println("task all commit");
        threadPool.shutdown();
    }
}
