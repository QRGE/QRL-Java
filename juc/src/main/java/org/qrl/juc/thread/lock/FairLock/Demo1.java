package org.qrl.juc.thread.lock.FairLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 大多数情况下, 锁都是非公平的, 加入ThreadA和ThreadB都在申请LockA, 系统只会从阻塞队列中随机获取一个线程让它获取LockA, 不能保证公平性
 *      - 难道随机不是一种公平吗?
 *      - synchronized是非公平锁
 *
 * 公平锁可以保证先到先得, 不会出现线程饥饿现象
 *      - ReentrantLock(boolean fair), 可以设置锁是否为公平锁
 *      - 公平锁必须要求系统维护一个有序队列, 公平锁的实现成本比较高, 性能也比较低, 因此默认情况下锁是非公平的(把线程对象都放到队列里先进先出后回到队列末尾?)
 *
 */
public class Demo1 {
    static ReentrantLock unfairLock = new ReentrantLock();
    static ReentrantLock fairLock = new ReentrantLock(true);

    public static void main(String[] args) {
        Runnable unfairRunnable = () -> {
            while (true){
                try {
                    unfairLock.lock();
                    System.out.println(Thread.currentThread().getName() + " get Lock");
                } finally {
                    unfairLock.unlock();
                }
            }
        };
        Runnable fairRunnable = () -> {
            while (true){
                try {
                    fairLock.lock();
                    System.out.println(Thread.currentThread().getName() + " get Lock");
                } finally {
                    fairLock.unlock();
                }
            }
        };


        for (int i = 0; i < 10; i++) {
            // 非公平锁会倾向于让一个线程再次获得已经持有的锁, 这种策略比较高效, 但并不公平
            // new Thread(unfairRunnable).start();

            // 如果是公平锁, 多个线程不会发生同一个线程连续多次获得锁
            new Thread(fairRunnable).start();
        }
    }
}
