package org.qrl.juc.thread.AtomicClass;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Demo3_AtomicIntegerArray {

    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread();
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(atomicIntegerArray);
    }

    static class MyThread extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 10; j++) {
                    atomicIntegerArray.getAndIncrement(j % atomicIntegerArray.length());
                }
            }
        }
    }
}
