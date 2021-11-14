package org.qrl.tools.juc.thread.Communication;


import java.util.ArrayList;

/**
 * wait(): 可以使当前代码的线程进入等待状态(WAITING), 直到被唤醒或被中断
 *      - wait()只能在同步代码块中由"锁对象"调用
 *      - 调用wait()后会立刻释放锁对象
 *      - wait(long n): 让线程进入TIME_WAITING状态, n ms之内没有被唤醒就会自动唤醒
 *
 * notify(): 可以唤醒线程, 该方法也必须在同步代码块中由"锁对象"调用
 *      - wait()/notify(): 如果不用锁对象执行, 会抛出 IllegalMonitorStateException异常
 *      - 如果由多个在WAITING状态的线程, notify()方法只能唤醒其中"一个"线程(具体唤醒哪个不好说, 就如同你不知道克洛丝什么时候会暴击)
 *      - notify()会等当前的同步代码块执行完毕后才唤醒线程, 释放锁对象
 *
 * notifyAll(): 可以唤醒所有进入等待状态的线程
 *
 * interrupt(): 当线程处于wait()等待状态时, 调用"线程对象"的interrupt()可以中断线程的等待状态, 并且会报错InterruptedException
 */
public class UncaughtExceptionHandlerDemo {

    private static final Object LOCK = new Object();

    // 不在synchronized中调用wait方法会报错IllegalMonitorStateException
    void waitTest1(){
        String name = "ZhangSan";
        try {
            name.wait(); // 会报错IllegalMonitorStateException
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 在synchronized中需要用锁对象调用wait()
    void waitTest2() throws InterruptedException {
        String name = "ZhangSan";
        System.out.println("Work prepare...");
        synchronized(name){
            System.out.println("Work start...");
            name.wait(); // 此时不会报错, 但你永远不会Work Done, 就如同阿米娅遇到了彩虹小队
            System.out.println("Work Done...");
        }
    }

    // 线程A中lockObj.wait()后, 线程B需要用同一个lockObj.notify()去唤醒对象
    void waitTest3() throws InterruptedException {
        Object lock = new Object();
        Thread myThread1 = new Thread(() -> {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                try {
                    lock.wait(); // 线程进入BLOCKED阻塞状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " done...");
            }
        }, "myThread1");

        Thread myThread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " notify!");
                lock.notify(); // 唤醒在lock锁对象上等待的某一个线程(lock锁对象上的?)
                System.out.println(Thread.currentThread().getName() + " Done...");
            }
        }, "MyThread2");

        myThread1.start();
        Thread.sleep(2000); // 确保线程1开启
        myThread2.start();
    }

    // 线程A中lockObj.wait()后会释放当前的锁对象, 然后在线程B的synchronized的同代码块运行完后才会释放lockObj
    // 即lockObj.notify()不会立刻释放lockObj
    void notifyTest1() throws InterruptedException {
        ArrayList<Integer> numbers = new ArrayList<>();
        Thread myThread1 = new Thread(() -> {
            synchronized (numbers) {
                if (numbers.size() != 10) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is waiting...");
                        numbers.wait();
                        System.out.println(Thread.currentThread().getName() + " Done!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "myThread1");
        Thread myThread2 = new Thread(() -> {
            synchronized (numbers) {
                System.out.println(Thread.currentThread().getName() + " is working!");
                for (int i = 0; i < 10; i++) {
                    numbers.add(i);
                    System.out.println("Size: " + numbers.size());
                    if (numbers.size() == 10) {
                        numbers.notify();
                        System.out.println("A thread is notified");
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Done!");
            }
        }, "myThread2");
        myThread1.start();
        Thread.sleep(1000);
        myThread2.start();
    }

    // interrupt()会中断线程的wait()等待
    void interruptTest() throws InterruptedException {
        Thread myThread1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName() + " Done...");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "is interrupted!");
                    e.printStackTrace();
                }
            }
        }, "myThread1");
        myThread1.start();

        Thread.sleep(1000);

        myThread1.interrupt();
    }

    // notifyAll()唤醒所有,
    void notifyAllTest() throws InterruptedException {
        Thread myThread1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName() + " Done...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "myThread1");
        Thread myThread2 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName() + " Done...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "myThread2");
        Thread myThread3 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName() + " Done...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "myThread3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        Thread.sleep(2000);
        synchronized (LOCK){
            System.out.println("NotifyAll threads!");
            LOCK.notifyAll(); // 唤醒所有进入等待状态的线程, 等于萨卡兹哨兵唤醒了所有萨卡兹人
        }
    }

}
