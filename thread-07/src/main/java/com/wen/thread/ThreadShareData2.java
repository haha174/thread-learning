package com.wen.thread;

public class ThreadShareData2 {
    public static void  main(String[] args ){
        ShareData1 sd1=new ShareData1();
        new Thread(new Runnable1(sd1)).start();
        new Thread(new Runnable2(sd1)).start();
    }
}
class Runnable1 implements  Runnable{
    private ShareData1 sd1;

    public Runnable1(ShareData1 sd1){
        this.sd1=sd1;
    }
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                sd1.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Runnable2 implements  Runnable{
    private ShareData1 sd1;

    public Runnable2(ShareData1 sd1){
        this.sd1=sd1;
    }
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                sd1.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class ShareData1{
    private int j=0;
    public synchronized void increment(){
        System.out.print(j+" ");
        j++;
        System.out.println(" add after "+j);
    }
    public synchronized void decrement(){
        System.out.print(j+" ");
        j--;
        System.out.println(" decre after "+j);
    }

}
