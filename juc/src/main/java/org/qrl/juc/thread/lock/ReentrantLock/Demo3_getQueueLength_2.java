package org.qrl.juc.thread.lock.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * int getWaitQueueLength(Condition condition): 返回在某个Condition下等待的线程"预估"数量
 */
public class Demo3_getQueueLength_2 {

    static class Service{
        private static final ReentrantLock lock = new ReentrantLock();
        private static final Condition condition = lock.newCondition();

        public void waiting(){
            try {
                lock.lock();
                // 塑料英语 /_ \
                System.out.println(Thread.currentThread().getName() +
                        " before waiting, the count of the thread in WAITING and in condition is " +
                        lock.getWaitQueueLength(condition));
                condition.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void wakeUp(){
            try {
                lock.lock();
                condition.signalAll();
                System.out.println("Wake up all threads, now the count of thread in WAITING and in condition is " +
                        lock.getWaitQueueLength(condition));
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Runnable r = service::waiting;
        for (int i = 0; i < 10; i++) {
            new Thread(r).start();
        }
        Thread.sleep(1000);
        service.wakeUp();
    }
}
