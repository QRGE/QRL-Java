package org.qrl.juc.thread.basic;

public class MyThread8 extends Thread{

    @Override
    public void run(){
        this.setName("MyThread8");
        System.out.println("ThreadName: " + Thread.currentThread().getName() +
                ", id: " + this.getId());
    }
}