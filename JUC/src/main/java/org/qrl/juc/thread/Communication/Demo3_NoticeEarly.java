package org.qrl.juc.thread.Communication;

/**
 * 通知过早(notify())可能会导致线程丢失
 */
public class Demo3_NoticeEarly {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread myThread1 = new Thread(() -> {
            synchronized (LOCK){
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName() +  " Done!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "myThread1");
        Thread myThread2 = new Thread(() -> {
            synchronized (LOCK){
                System.out.println(Thread.currentThread().getName() + " is working");
                LOCK.notify();
                System.out.println(Thread.currentThread().getName() +  " Done!");
            }
        }, "myThread2");
        // myThread2先开启执行notify() -> myThread1还没有进入WAITING状态 -> myThread1启动进入WAITING状 -> myThread1无法被唤醒, 造成线程丢失
        myThread2.start();
        myThread1.start();
    }
}
