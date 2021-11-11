package org.qrl.juc.thread.Lock.IntrinsicLock.Synchronized;

// synchronized修饰方法时, 默认使用 this对象 作为锁对象
public class Demo4 {

    public void testMethod1() {
        // 可以使用this当前对象作为锁对象, 锁的代码块里在某个时刻只能被一个线程执行
        synchronized (this){
            for (int i = 1; i <= 30; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }

    // 此方法默认的锁对象为this对象, 同上
    public synchronized void testMethod2(){
        for (int i = 1; i <= 30; i++) {
            System.out.println(Thread.currentThread().getName() + " --> " + i);
        }
    }

    public static void main(String[] args) {
        Demo4 lockDemo1 = new Demo4();

        // 使用常量作为锁对象时, 即使是不同对象之间或者是静态方法, 它们获取的锁对象是唯一的(即设置的常量), 可以实现同步
        new Thread(lockDemo1::testMethod1).start();
        new Thread(lockDemo1::testMethod2).start();
    }
}
