package org.qrl.juc.thread.Basic;

public class MyThread9 extends Thread{

    @Override
    public void run(){
        long begin = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("MyThread9 Pass: " + (end - begin));
    }
}
