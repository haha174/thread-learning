package com.web.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main4 {
    public static void main(String[] args){

        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            public void run() {
             System.out.print("booming");
            }
        },5,2,TimeUnit.SECONDS);
    }
}
