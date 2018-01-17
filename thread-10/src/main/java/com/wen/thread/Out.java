package com.wen.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Out {
    static  Lock lock=new ReentrantLock();
    public static void out(String name){
        lock.lock();
        try {
            for (int i=0;i<name.length();i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }finally {
            lock.unlock();
        }

    }
}
