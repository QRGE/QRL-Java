package org.qrl.juc.thread.basic.CreateThread;

/**
 *  创建线程方式:
 *      - 继承Thread类并重写run方法
 *      - 实现Runnable接口并重写run方法, 创建线程时将Runnable接口的实现类对象作为参数传入Thread的构造方法
 *          - 由于Runnable接口是函数时接口, 则可以直接传入一个lambda表达式
 */
public class Zinc {
    public static void main(String[] args) {
        Demo1_Thread threadA = new Demo1_Thread();
        threadA.start();

        Thread threadB = new Thread(new Demo2_Runnable());
        threadB.start();
    }
}


