package com.wen.thread;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.ExecutionException;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                int task=new Random().nextInt(5000);
                Thread.sleep(task);
                return task;
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
