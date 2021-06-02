package qr.Java.Thread.Lock.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * int getQueueLength: 返回正在等待状态的线程的"预估"数量
 * int getWaitQueueLength(Condition condition): 返回在某个Condition下等待的线程"预估"数量
 */
public class Demo3_getQueueLength {

    static ReentrantLock lock = new ReentrantLock();

    public static void method1(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +
                    " get lock, the count of thread in WAITING is " + lock.getQueueLength());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable r = Demo3_getQueueLength::method1;
        for (int i = 0; i < 10; i++) {
            new Thread(r).start();
        }
    }
}
