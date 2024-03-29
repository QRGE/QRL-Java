package org.qrl.juc.thread.basic;

import org.qrl.tools.util.thread.ThreadTool;

/**
 * boolean isAlive(): 判断当前线程是否活跃
 */
public class Demo4_isAlive {

    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("run方法, isAlive: " + this.isAlive());
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin: " + myThread.isAlive());
        myThread.start(); // 开启线程后执行run方法, run方法中的this.isAlive() -> true
        ThreadTool.sleepMillisecond(200);
        System.out.println("end: " + myThread.isAlive()); // 线程方法执行完毕, 线程关闭, myThread.isAlive() - > true
    }
}
