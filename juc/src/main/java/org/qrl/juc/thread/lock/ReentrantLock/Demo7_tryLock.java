package org.qrl.juc.thread.lock.ReentrantLock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock(long time, TimeUnit unit): 在给定等待时间内如果获取的锁对象没有被其他线程持有, 且当前线程没有被中断, 则获取锁对象
 *      - 通过该方法可以实现锁对象的限时等待
 *
 * tryLock(): 申请锁对象时如果锁对象被其他的线程占用, 则放弃申请锁, 否则获得该锁
 *      - 即没有耐心的暴躁老哥
 */
public class Demo7_tryLock {

    static class TimeLock implements Runnable{

        private final static ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                if (lock.tryLock(3, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName() + " get Lock");
                    Thread.sleep(5000);
                }else {
                    System.out.println(Thread.currentThread().getName() + " quit Lock");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (lock.isHeldByCurrentThread()) lock.unlock();
            }
        }
    }

    static class TimeLock2 implements Runnable{

        private final static ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                if (lock.tryLock()){
                    System.out.println(Thread.currentThread().getName() + " get Lock");
                    Thread.sleep(5000);
                }else {
                    System.out.println(Thread.currentThread().getName() + " quit Lock");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (lock.isHeldByCurrentThread()) lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
        Thread myThread1 = new Thread(timeLock, "myThread1");
        Thread myThread2 = new Thread(timeLock, "myThread2");
        myThread1.start();
        // 假设myThread1先执行, myThread2会因为得不到锁对象而放弃锁
        myThread2.start();
    }

    // 演示一个tryLock()的作用
    @Test
    void tryLockTest(){
        TimeLock2 timeLock2 = new TimeLock2();
        Thread myThread1 = new Thread(timeLock2, "myThread1");
        Thread myThread2 = new Thread(timeLock2, "myThread2");
        myThread1.start();
        myThread2.start();
    }
}
