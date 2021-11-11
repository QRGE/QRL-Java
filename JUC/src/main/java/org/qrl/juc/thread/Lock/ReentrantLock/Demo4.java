package org.qrl.juc.thread.Lock.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo4 {

    static class SubThread extends Thread{
        private static final Lock lock = new ReentrantLock(); // 静态对象类型变量一个类中共享一个对象
        public static int num = 0;

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                try {
                    lock.lock();
//                    lock.lock(); Reentrant是可重入锁, 可以多次获取, 如果多次获取了要注意释放对应的获取次数, 否则会一直持有锁陷入卡死状态
                    num++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            SubThread thread1 = new SubThread();
            SubThread thread2 = new SubThread();
            thread1.start();
            thread1.join(); // 在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B
            thread2.start();
            thread2.join();
            System.out.println(SubThread.num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
