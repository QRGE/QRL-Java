package qrl.juc.thread.Lock.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lockInterruptibly(): 如果当前线程未被中断则获得锁, 如果当前线程被中断则放弃对锁的获取且产生异常
 * 对于synchronized内部所而言, 如果一个线程正在等待锁, 只有两种结果:
 *      - 获得锁执行线程任务
 *      - 一直处于等待锁的状态
 * ReentrantLock提供了另外一种状态, 在等待锁的过程中, 程序可以根据需要取消对锁的请求
 *      - 即lockInterruptibly, 当前线程取消了可以放弃请对锁的申请
 */
public class Demo5_lockInterruptibly {

    static class Service{
        private final static Lock lock = new ReentrantLock();

        public void serviceMethod(){
            try {
                lock.lockInterruptibly(); // 线程被中断, 不会获得锁, 会产生异常
                System.out.println(Thread.currentThread().getName() + " , begin lock...");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " , end lock...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " release lock...");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Thread myThread1 = new Thread(service::serviceMethod, "myThread1");
        Thread myThread2 = new Thread(service::serviceMethod, "myThread2");
        myThread1.start();
        Thread.sleep(500);

        myThread2.start();
        Thread.sleep(500);
        myThread2.interrupt();
    }

}
