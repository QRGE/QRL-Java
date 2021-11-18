package org.qrl.juc.thread.basic.pause;

import org.qrl.tools.util.thread.ThreadTool;

/**
 * suspend() 用于暂停线程
 * resume() 用于恢复线程
 * @author qr
 * @date 2021/11/16 6:06 PM
 */
public class Demo1_SuspendAndResume {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
           int i = 0;
           while (true) System.out.println(i++);
        });
        thread.start();
        ThreadTool.sleepMillisecond(10);
        System.out.println("----------暂停----------");
        thread.suspend();
        ThreadTool.sleepMillisecond(10);
        System.out.println("----------恢复----------");
        thread.resume();
        ThreadTool.sleepMillisecond(10);
        System.out.println("----------结束----------");
        thread.stop();
    }
}
