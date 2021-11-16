package org.qrl.juc.thread.basic.state;

import org.qrl.tools.util.thread.ThreadTool;

/**
 * @author qr
 * @date 2021/11/16 3:36 PM
 */
public class Demo1_states {

    public static void main(String[] args) {
        // 启动一个线程让其等待3秒
        Thread thread = new Thread(() -> ThreadTool.sleepSecond(2));
        // 还没调用 start() 获取线程状态是 NEW,
        System.out.println(thread.getState());
        thread.start();
        // start() 后立即获取线程状态为 RUNNABLE
        System.out.println(thread.getState());
        ThreadTool.sleepMillisecond(20);
        // thread 在 sleep 中获取线程状态为 TIMED_WAITING
        System.out.println(thread.getState());
        ThreadTool.sleepSecond(2);
        // 等待线程运行结束后获取线程状态为 TERMINATED
        System.out.println(thread.getState());
    }
}
