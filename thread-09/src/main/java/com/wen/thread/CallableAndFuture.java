package com.wen.thread;

import com.sun.corba.se.spi.orbutil.fsm.Guard;

import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService threadPool= Executors.newSingleThreadExecutor();
        Future future= threadPool.submit(new Callable<String>(){

            public String call() throws Exception {
              Thread.sleep(2000);
                return "hello";
            }
        });
        System.out.println("等待结果");
        System.out.println("结果"+future.get(1,TimeUnit.SECONDS));
        System.out.println("结果"+future.get());
    }
}
