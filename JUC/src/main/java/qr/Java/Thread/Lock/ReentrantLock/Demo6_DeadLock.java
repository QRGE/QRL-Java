package qr.Java.Thread.Lock.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lockInterruptibly()或tryLock(long time, TimeUnit unit)可以避免死锁
 */
public class Demo6_DeadLock {

    public static void main(String[] args) {
        IntLock intLock1 = new IntLock(1);
        IntLock intLock2 = new IntLock(2);
        Thread myThread1 = new Thread(intLock1, "myThread1");
        Thread myThread2 = new Thread(intLock2, "myThread2");
        myThread1.start();
        myThread2.start();
        // 中断myThread2的异常, 放弃对lock1的申请并且释放lock2, 此时myThread1获得lock2正常运行至结束
        if (myThread2.isAlive()) myThread2.interrupt();
    }

    static class IntLock implements Runnable{

        private final static ReentrantLock lock1 = new ReentrantLock();
        private final static ReentrantLock lock2 = new ReentrantLock();
        private final int lockNum;

        public IntLock(int lockNum){
            this.lockNum = lockNum;
        }

        @Override
        public void run() {
            try {
                if (lockNum % 2 == 1){
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " get lock1, need lock2");
                    Thread.sleep(500);
                    lock2.lockInterruptibly();
                }else {
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + " get lock2, need lock1");
                    Thread.sleep(500);
                    lock1.lockInterruptibly();
                }
                System.out.println(Thread.currentThread().getName() + "get lock1 and lock2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // isHeldByCurrentThread()可以判断当前线程是否持有指定锁对象
                if (lock1.isHeldByCurrentThread()) lock1.unlock();
                if (lock2.isHeldByCurrentThread()) lock2.unlock();
                System.out.println(Thread.currentThread().getName() + " is done");
            }
        }
    }


}
