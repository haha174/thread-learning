package com.wen.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    Map<String,User> map=new HashMap<String,User>();
    ReadWriteLock rw=new ReentrantReadWriteLock();
    public User getRntity(String name){
        try {
            rw.readLock().lock();
            User user=map.get(name);
            if (user==null){
                rw.readLock().unlock();
                rw.writeLock().lock();
                try {
                    if (user==null){
                        user=getUser(name);
                        map.put(name,user);
                    }
                    return user;
                }finally {
                    rw.writeLock().unlock();
                }
            }else{
                return user;
            }
        }finally {
            rw.readLock().unlock();
        }

    }
    public User getUser(String name){
        return new User();
    }
}
class User{};
