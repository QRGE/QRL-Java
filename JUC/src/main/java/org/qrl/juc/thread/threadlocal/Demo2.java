package org.qrl.juc.thread.threadlocal;

import java.util.Date;

public class Demo2 {

    static ThreadLocal<Date> threadLocal = new SubThreadLocal();

    /**
     * 可以通过继承ThreadLocal类重写initialValue方法进行设置初始值
     */
    static class SubThreadLocal extends ThreadLocal<Date>{
        @Override
        protected Date initialValue() {
            return new Date();
        }
    }

    static class MyThread extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " value: " + threadLocal.get());
                if (threadLocal.get() == null){
                    threadLocal.set(new Date());
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.setName("myThread1");
        myThread1.start();

        MyThread myThread2 = new MyThread();
        myThread2.setName("myThread2");
        myThread2.start();
    }
}
