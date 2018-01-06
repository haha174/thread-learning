package com.wen.thread;

import java.util.*;
import java.util.TimerTask;

public class TraditionalTime {

    public  static int count=0;

    public static void main(String[] args){
        /*new Timer().schedule(new TimerTask() {
            public void run() {
                    System.out.println("bomb");
            }
        },1000,300);
        new Timer().schedule(new TimerTask() {
            public void run() {
                System.out.println("bombing");
            }
        },1000,300);
        */class MyTask extends  TimerTask{
            public void run() {
                count++;
                System.out.println("bombing");
                new Timer().schedule(new MyTask(),2000+2000*(count%2));
            }
        }
        new Timer().schedule(new MyTask(),2000);
        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
