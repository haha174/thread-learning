package thread;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadScopShareData {
    public static int data=0;
    static ThreadLocal<Integer> map=new ThreadLocal<Integer>();
    public static void main(String[] args){
        for (int i=0;i<2;i++)
        new Thread(new Runnable() {
            public void run() {
                data=new Random().nextInt();
                map.set(data);
                System.out.println(Thread.currentThread().getName()+" has put data: "+data);
                new A().get();
                new B().get();
            }
        }).start();
    }
    static  class A{
        public int get(){
            System.out.println(Thread.currentThread().getName()+" has A get data: "+map.get());
            return map.get();
        }
    }
    static  class B{
        public int get(){
            System.out.println(Thread.currentThread().getName()+" has B get data: "+map.get());
            return map.get();
        }
    }
}
