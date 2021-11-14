package org.qrl.juc.thread.lock.ReentrantLock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁的可重入性:
 *      当一个线程获得一个对象锁后, 再次请求该对象锁时可以获得该对象锁
 *      synchronized也是可重入锁
 * JDK5中增加了Lock锁接口, 有Reentrant实现类, ReentrantLock锁称为可重入锁, 它的功能比synchronized多
 *
 * Reentrant的常用方法:
 *      lock() 获得锁对象
 *      unlock() 释放锁
 *      isLock() 查询锁是否被线程持有
 *      boolean isHeldByCurrentThread(): 判断锁对象是否被当前线程持有
 *      lockInterruptibly(): 如果当前线程未被中断则获得锁, 如果当前线程被中断则放弃对锁的获取且产生异常
 *      boolean tryLock(long time, TimeUnit unit): 在给定的等待时长内对应的lockObj没有被另外的线程持有,则获得该锁, 超过时间则放弃该锁对象
 *                                         获取锁成功时返回true, 否则返回false
 *      boolean tryLock(): 仅在锁对象没有被其他线程持有的情况下获取锁, 如果在申请时锁对象被其他线程持有, 则直接放弃对锁的申请
 *                 获取锁成功时返回true, 否则返回false
 *
 *      int getHoldCount(): 方法返回当前线程调用lock方法的次数
 *
 *      int getQueueLength(): 返回正在等待状态的线程的"预估"数量
 *      int getWaitQueueLength(Condition condition): 返回在某个Condition下等待的线程"预估"数量
 *
 *      boolean hasQueuedThread(Thread thread): 查询指定的线程是否在等待锁
 *      boolean hasQueuedThreads(): 查询正在等待锁的线程
 *
 *      boolean isFair(): 判断锁对象是否为公平锁
 */
public class Demo1 {

    static ReentrantLock lock = new ReentrantLock();

    public static void method1(){
        // 使用ReentrantLock时经常在try中lock(), finally中unlock()
        try {
            lock.lock(); // 获得锁
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        }finally {
            lock.unlock();
        }
    }

    @Test
    void ReentrantLockTest1(){
        Runnable r = Demo1::method1;
        // 下面三个线程是可以实现同步的
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
