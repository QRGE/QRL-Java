package org.qrl.juc.thread.basic.stop;

/**
 * @author qr
 * @date 2021/11/15 11:43 AM
 */
public class Demo3_Stop {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            while (true){
                System.out.println("你好哇!");
            }
        }, "thread_basic_stop_demo3");
        thread.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // threadObj().stop() 此方法已经过时
        thread.stop();
    }
}
