package org.qrl.juc.thread.lock.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo10_hasWaiters {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    static void method1(){
        try {
            lock.lock();
            System.out.println("Any Threads is waiting condition: " + lock.hasWaiters(condition) +
                    ", waitQueueLength: " + lock.getWaitQueueLength(condition));
            System.out.println(Thread.currentThread().getName() + " get lock.");
            condition.await(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " release lock.");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable r = Demo10_hasWaiters::method1;
        for (int i = 0; i < 10; i++) {
            new Thread(r).start();
        }
    }
}
