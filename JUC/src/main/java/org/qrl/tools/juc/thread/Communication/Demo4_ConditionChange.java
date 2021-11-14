package org.qrl.tools.juc.thread.Communication;

import java.util.ArrayList;
import java.util.List;

public class Demo4_ConditionChange {

    static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Thread addThread = new Thread(new AddThread(), "addThread");
        Thread subThread1 = new Thread(new SubThread(), "subThread1");
        Thread subThread2 = new Thread(new SubThread(), "subThread2");

        // 报错执行顺序:
        // subThread1进入WAITING -> addThread获取CPU执行权, 唤醒subThread1 -> subThread2因为list有数据取出数据,正常运行结束
        // -> subThread1被唤醒后再次从list获取数据, 此时list已经没有数据, 抛出异常
        // 解决报错方法: 将subThread中的if改成while, 每次获取list参数时都会进行判断
        subThread1.start();
        subThread2.start();
        addThread.start();

    }

    static class SubThread implements Runnable{
        @Override
        public void run() {
            synchronized (list){
                if (list.size()==0){
                    try {
                        System.out.println(Thread.currentThread().getName() + " is waiting...");
                        list.wait();
                        System.out.println(Thread.currentThread().getName() + " Done...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer removed = list.remove(0);
                System.out.println(Thread.currentThread().getName() + " gets " + removed + " from list");
            }
        }
    }

    static class AddThread implements Runnable{
        @Override
        public void run() {
            synchronized (list){
                list.add(1);
                list.notify();
            }
        }
    }
}
