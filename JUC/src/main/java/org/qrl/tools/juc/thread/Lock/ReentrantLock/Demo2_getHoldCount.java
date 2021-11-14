package org.qrl.tools.juc.thread.Lock.ReentrantLock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * int getHoldCount(): 方法返回当前线程调用lock方法的次数
 */
public class Demo2_getHoldCount {

    static ReentrantLock lock = new ReentrantLock();

    public static void getLock1(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " hold count: " + lock.getHoldCount());
            // Reentrant是可重入锁, 在getLock1中调用getLock2, getLock2依然可以获得lock
            getLock2();
        }finally {
            lock.unlock();
        }
    }

    public static void getLock2(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " hold count: " + lock.getHoldCount());
        }finally {
            lock.unlock();
        }
    }

    @Test
    void getHoldCountTest1(){
        getLock1();
        new Thread(Demo2_getHoldCount::getLock1, "myThread1").start();
    }
}
