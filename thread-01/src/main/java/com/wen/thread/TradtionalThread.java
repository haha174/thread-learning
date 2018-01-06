package com.wen.thread;

public class TradtionalThread {
    public static void main(String[] args){
        Thread thread=new Thread(){
            public  void run(){
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(Thread.currentThread().getName());
                    System.out.println(this.getName());
                }
            }
        };
        thread.start();
        Thread thread1=new Thread(new Runnable() {
            public  void run(){
                while (true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        thread1.start();
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runnable"+Thread.currentThread().getName());
        }
    }){
        public void run(){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread"+Thread.currentThread().getName());
        }
    }.start();
    }

}
