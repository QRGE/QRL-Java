package qrl.juc.thread.Lock.ReentrantLock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的newCondition()可以返回一个Condition对象, 通过Condition对象的await()和signal()方法可以进行线程的等待和唤醒
 *      - 类似Thread的wait()和notify()
 *      - 使用await()或signal()之前都需要获取对应的锁对象, 否则会产生异常IllegalMonitorStateException
 *      - 同notifyAll(), signalAll()可以唤醒所有等待的线程
 *
 * condition对象可以有多个, 可以利用不同的condition对象await()及signal()指定的线程
 */
public class Demo8_Condition {
    private final static ReentrantLock lock = new ReentrantLock();

    private final static Condition conditionA = lock.newCondition();
    private final static Condition conditionB = lock.newCondition();

    static class SubThreadA extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock...");
                conditionA.await();
                System.out.println(Thread.currentThread().getName() + " just entered the WAITING state and is now awakened ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread())
                    lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubThreadA subThread = new SubThreadA();
        subThread.setName("Thread-A");
        subThread.start();
        Thread.sleep(3000);
        lock.lock();
        // Thread-A利用conditionA进行等待, 如果你用conditionB.signal(), 就唤不醒ThreadA
        conditionA.signal();
//        conditionB.signal();
        lock.unlock();
    }
}
