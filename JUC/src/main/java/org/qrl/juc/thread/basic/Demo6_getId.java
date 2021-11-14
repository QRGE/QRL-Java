package org.qrl.juc.thread.basic;

/**
 * getId(): 获取线程的Id值, 每个线程都有一个唯一的Id号
 */
public class Demo6_getId {

    static class myThread6 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println(main.getName() + ":" + main.getId());
        myThread6 myThread6 = new myThread6();
        myThread6.setName("myThread6");
        myThread6.start();
    }
}
