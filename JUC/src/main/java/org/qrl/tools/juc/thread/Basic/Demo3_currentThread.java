package org.qrl.tools.juc.thread.Basic;

/**
 * currentThread(): 返回当前代码段所属的线程对象
 */
public class Demo3_currentThread {

    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        Thread.State state = Thread.currentThread().getState();
        System.out.println(name);
        System.out.println(state);

        // 总是就是返回一个线程, 线程的toString()为 ThreadName, Priority, ThreadCroupName
        Thread thread = Thread.currentThread();
        System.out.println(thread);
    }
}
