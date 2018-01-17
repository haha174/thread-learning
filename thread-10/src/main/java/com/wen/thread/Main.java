package com.wen.thread;

public class Main {
    public static void main(String args[]){
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                      //  Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Out.out("hahahahahahahaha");
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                       // Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Out.out("174174174174174174");
                }
            }
        }).start();
    }
}
