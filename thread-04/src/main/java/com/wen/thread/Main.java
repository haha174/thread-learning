package com.wen.thread;

public class Main {
    public  static  void main(String[] args){
        final Business bs=new Business();
        new Thread(new Runnable() {
            public void run() {
                for (int i=1;i<=50;i++){
                    bs.sub(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                for (int i=1;i<=50;i++){
                    bs.main(i);
                }
            }
        }).start();
    }
}
