package com.wen.thread;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndCompletion {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService threadPool= Executors.newFixedThreadPool(10);
        CompletionService<Integer> com=new ExecutorCompletionService<Integer>(threadPool);
        for (int i=1;i<=10;i++){
            final int task=i;
            com.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return task;
                }
            });
        }
        System.out.println("等待结果");

        for (int i=1;i<=10;i++){
            System.out.println("结果"+com.take().get());
        }


    }
}
