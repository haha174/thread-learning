package com.wen.thrad;



public class OutPut {
    public  void outPut(String name){
            for (int i=0;i<name.length();i++){
                System.out.print(name.charAt(i));
        }
        System.out.println();
    }
    public  void outPut1(String name){
        synchronized(this){
            for (int i=0;i<name.length();i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
    public  synchronized void outPut2(String name){
        for (int i=0;i<name.length();i++){
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }
    public  static synchronized void outPut3(String name){
        for (int i=0;i<name.length();i++){
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }
}
