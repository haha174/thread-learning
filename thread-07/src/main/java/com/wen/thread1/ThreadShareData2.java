package com.wen.thread1;

public class ThreadShareData2 {
    public static void  main(String[] args ){

        final ShareData1 sd1=new ShareData1();
        new Thread(new Runnable(){

            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        sd1.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }            }
        }).start();
        new Thread(new Runnable(){

            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        sd1.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }            }
        }).start();
        new Thread(new Runnable(){

            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        sd1.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }            }
        }).start();
        new Thread(new Runnable(){

            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        sd1.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }            }
        }).start();

    }
}

class ShareData1 {
    private int j=0;
    public synchronized void increment(){
        System.out.print(j+" ");
        j++;
        System.out.println(" add after "+j);
    }
    public synchronized  void decrement(){
        System.out.print(j+" ");
        j--;
        System.out.println(" decre after "+j);
    }

    public void run() {

    }
}
