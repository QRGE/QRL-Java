package qrl.juc.thread.Lock.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *      boolean hasQueuedThread(Thread thread): 查询指定的线程是否在等待锁
 *      boolean hasQueuedThreads(): 查询正在等待锁的线程
 */
public class Demo9_hasQueueThread {

    static ReentrantLock lock = new ReentrantLock();

    public static void waitMethod(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " release lock");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r = Demo9_hasQueueThread::waitMethod;
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
            threads[i].setName("myThread" + i);
            threads[i].start();
        }
        Thread.sleep(1000);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " is waiting lock: " + lock.hasQueuedThread(thread));
        }

        Thread.sleep(1000);
        System.out.println("Any Thread is waiting lock: " + lock.hasQueuedThreads());
    }
}
