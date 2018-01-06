package com.wen.thread;


public class Business {
    private boolean bShouldSub=true;
    public synchronized  void sub(int i){
        while (!bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j=1;j<=10;j++){
            System.out.println("sub sequece "+i+" loop for "+j);
        }
        bShouldSub=false;
        this.notify();
    }
    public synchronized  void main(int i){
        while (bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j=1;j<=100;j++){
            System.out.println("main sequece "+i+" loop for "+j);
        }
        bShouldSub=true;
        this.notify();
    }
}
