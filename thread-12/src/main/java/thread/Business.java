package thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class Business {
     Lock lock=new ReentrantLock();
     Condition condition1=lock.newCondition();
     Condition condition2 =lock.newCondition();
     Condition condition3 =lock.newCondition();
    private  int bShouldSub=1;
    public   void sub1(int i){
        lock.lock();
        try {
            while (bShouldSub!=1){
                try {
                    condition1.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int j=1;j<=5;j++){
                System.out.println("sub1 sequece "+i+" loop for "+j);
            }
            bShouldSub=2;
            condition2.signal();
        }finally {
            lock.unlock();
        }

    }
    public   void sub2(int i) {
        lock.lock();
        try {
            while (bShouldSub!=2) {
                try {
                  //  this.wait();
                    condition2.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 20; j++) {
                System.out.println("main sequece " + i + " loop for " + j);
            }
            bShouldSub=3;
            condition3.signal();
        }finally {
            lock.unlock();
        }
    }
    public   void sub3(int i){
        lock.lock();
        try {
            while (bShouldSub!=3){
                try {
                    condition3.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int j=1;j<=30;j++){
                System.out.println("sub3 sequece "+i+" loop for "+j);
            }
            bShouldSub=1;
            condition1.signal();
        }finally {
            lock.unlock();
        }

    }
}
