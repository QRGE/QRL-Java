package org.qrl.juc.thread.Lock.IntrinsicLock.Synchronized;

// 用synchronized修饰代码块 synchronized( 锁对象 ) {...}
public class Demo1 {

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();

        // 假如此线程Thread-0先获得CPU的执行权, 调用lockDemo1对象执行testMethod(),并先获取到this对象的lockDemo1的锁,然后执行for循环
        new Thread(demo1::testMethod).start();
        // 由于synchronized内部锁是排他锁, 只能被一个线程持有, 只有等Thread-0释放锁后, Thread-1才能获取对象lockDemo1的锁

        // 在Thread-0执行for的期间, Thread-1获取CPU执行权, 由于并没有获得锁, Thread-1进入等待区等待lockDemo1对象的锁
        // 只有等待Thread-0释放锁, 然后Thread-1获取锁对象后, 才能执行对应的代码块
        new Thread(demo1::testMethod).start();

    }

    public void testMethod() {
        // 可以使用this当前对象作为锁对象, 锁的代码块里在某个时刻只能被一个线程执行
        synchronized (this){
            for (int i = 1; i <= 50; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }
}
