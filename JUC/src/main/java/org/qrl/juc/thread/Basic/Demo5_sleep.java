package org.qrl.juc.thread.Basic;

/**
 * void native sleep(long ms): 使线程停止
 */
public class Demo5_sleep {

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
