package com.wen.thrad;

public class TraditionalSynchronized {
    static  final OutPut outPut=new OutPut();
    public static void main(String[] args){
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPut.outPut("zhangsansansansan");
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPut.outPut3("lisisisisisi");
                }
            }
        }).start();
    }
}
