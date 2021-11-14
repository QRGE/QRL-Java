package org.qrl.tools.juc.thread.Basic;

/**
 * 各个线程的启动顺序 和 代码顺序 可能并没有关系
 */
public class Demo2_Sequence {

    public static void main(String[] args) {
        new Thread(Demo2_Sequence::doSomething).start();
        doSomething();
    }

    public static void doSomething(){
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
                int sleep = (int)(Math.random() * 1000);
                Thread.sleep(sleep);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
