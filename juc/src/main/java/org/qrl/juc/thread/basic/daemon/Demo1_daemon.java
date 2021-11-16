package org.qrl.juc.thread.basic.daemon;

import org.qrl.tools.util.thread.ThreadTool;

/**
 * 守护线程是一种特殊的线程, 当进程中不存在非守护线程了, 则守护线程自动销毁 <br/>
 * 典型的守护线程就是垃圾回收线程，当进程中没有非守护线程了，则垃圾回收线程也就没有存在的必要了，自动销毁。
 * @author qr
 * @date 2021/11/16 6:53 PM
 */
public class Demo1_daemon {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                int j = 0;
                while (true) System.out.println("Thread: " + Thread.currentThread().getName() +  " " +j++);
            });
            thread.setDaemon(true);
            thread.start();
        }
        // 当 main 线程睡眠停止后所有自定守护线程都会自动结束
        ThreadTool.sleepMillisecond(200);
    }
}
