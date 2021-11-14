package org.qrl.tools.juc.thread.Lock.IntrinsicLock.Synchronized;

/**
 * 死锁: 在多线程程序中, 同步时可能需要使用多个锁, 如果获取锁的顺序不一致, 可能会导致死锁
 * 避免死锁: 当需要获取多个锁时, 要保证所有线程获取锁的顺序保持一致
 */
public class Demo9_DeadLock {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.setName("a");
        MyThread thread2 = new MyThread();
        thread2.setName("b");
        // thread1需要先获取lock1再获取lock2, 而thread2需要先获取lock2再获取lock1
        // 如果thread1获取lock1后thread2先获lock2, 两者会进入卡住状态
        thread1.start();
        thread2.start();
    }

    static class MyThread extends Thread{

        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();

        @Override
        public void run(){
            if ("a".equals(Thread.currentThread().getName())){
                synchronized (lock1){
                    System.out.println("a线程获得了lock1锁, 还需要获取lock2锁");
                    synchronized (lock2){
                        System.out.println("a线程获得lock1后又获得了lock2锁");
                    }
                }
            }

            if ("b".equals(Thread.currentThread().getName())){
                synchronized (lock2){
                    System.out.println("a线程获得了lock1锁, 还需要获取lock2锁");
                    synchronized (lock1){
                        System.out.println("a线程获得lock1后又获得了lock2锁");
                    }
                }
            }
        }
    }
}
