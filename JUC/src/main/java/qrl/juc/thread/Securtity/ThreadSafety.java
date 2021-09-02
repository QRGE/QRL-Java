package qrl.juc.thread.Securtity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全问题:
 *    线程安全问题指多个线程对同一个对象的实例变量进行操作时,会出现值被改变,值不同步的情况,
 *    线程安全问题表现在三个方面,原子性, 可见性和有序性
 *
 *    原子性: 原子(Atomic)就是不可分割的意思, 原子操作的不可分割由两层含义:
 *       1) 访问(读,写)某个共享变量时, 从其他代码的角度看, 改操作要么已经完成, 要么尚未发生, 即其他线程无法看到当前操作的中间过程
 *       2) 访问同一组共享变量的原子操作是不能交错的(或者说各个线程之间的操作不能相互影响)
 *       例如在ATM取款只能成功或失败, 不能存了钱被吞了(异常状态)
 *       Java实现原子性的方式: 锁 / 处理器的CAS(Compare And Swap)指令
 *          锁具有排他性, 被锁的变量能保证在某一时刻能被一个线程访问
 *          CAS指令直接在硬件(处理器和内存)层次上实现, 可以理解成是硬件锁
 *    可见性: 多线程环境中, 一个线程对某个共享变量进行更新后, 后续其他线程可能无法立即读到这个更新结果, 这就是线程安全的另一种形式: 可见性(visibility)
 *       如果一个线程对共享变量更新后, 后续访问该变量的其他线程的其他线程可以读到这个更新结果, 称这个线程对共享变量的更新对其他线程可见,
 *       否则称这个线程对共享变量更新对其他线程不可见
 *       多线程因为可见性问题可能会导致其他线程读取到了旧数据(脏数据)
 */
public class ThreadSafety {
    public static void main(String[] args) {

        // MyInt myInt = new MyInt();
        MyAtomicInteger myAtomicInteger = new MyAtomicInteger();
        for (int i = 1; i <= 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(Thread.currentThread().getName() + "->" + myAtomicInteger.getNum());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    static class MyInt{
        int num;
        public int getNum(){
            return num++;
        }
    }

    // Java提供了一Atomic开头的各种线程安全类, 例如AtomicInteger

    static class MyAtomicInteger{
        AtomicInteger num = new AtomicInteger();

        public int getNum() {
            return num.getAndIncrement();
        }
    }
}
