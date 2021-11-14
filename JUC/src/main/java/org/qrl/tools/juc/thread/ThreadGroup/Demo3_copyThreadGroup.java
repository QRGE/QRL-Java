package org.qrl.tools.juc.thread.ThreadGroup;

public class Demo3_copyThreadGroup {

    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup group1 = new ThreadGroup("group1");
        ThreadGroup group2 = new ThreadGroup(mainGroup, "group2");

        Runnable r = ()-> System.out.println("Current Thread: " + Thread.currentThread());

        Thread myThread1 = new Thread(r, "myThread1");
        Thread myThread2 = new Thread(group1, r, "myThread2");
        Thread myThread3 = new Thread(group1, r, "myThread3");
        myThread1.start();
        myThread2.start();
        myThread3.start();

        Thread[] threadList = new Thread[mainGroup.activeCount()];
        // threadGroupObj.enumerate(Thread[] threads): threadGroup里的所有线程即子线程存放到threads中
        mainGroup.enumerate(threadList);
        for (Thread thread : threadList) {
            System.out.println(thread);
        }


    }
}
