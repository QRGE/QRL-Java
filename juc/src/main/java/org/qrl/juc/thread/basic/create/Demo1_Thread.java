package org.qrl.juc.thread.basic.create;

public class Demo1_Thread extends Thread{

    public static void main(String[] args) {
        Demo1_Thread thread = new Demo1_Thread();
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Create thead by extend firstThread");
    }
}
