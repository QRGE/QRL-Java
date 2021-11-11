package org.qrl.juc.thread.Communication;

// wait(long n) 线程进入TIME_WAITING状态, 如果n毫秒内没有被唤醒就会自动唤醒
public class Demo2_Wait {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread myThread1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    LOCK.wait(5000); // 测试方法不知道为什么执行不了wait()方法
                    System.out.println(Thread.currentThread().getName() + " waked up itself just now...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "myThread1");
        myThread1.start();
    }
}
