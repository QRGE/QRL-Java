package org.qrl.juc.thread.basic.Stop;

/**
 * 停止线程的方法:
 *      Thread.stop(): 此方法已过时,不推荐使用
 *      interrupt(): 给线程一个终端标记
 *      抛出异常
 *      在run方法中结合isInterrupt()方法return, break, 抛出异常等停止线程
 */
public class Sleep {

    public static void main(String[] args) {
        Thread myThread7 = new Thread(()->{
            try {
                System.out.println("Begin");
                Thread.sleep(200000);
                System.out.println("End");
            } catch (InterruptedException e) {
                System.out.println("Sleep is interrupted! " + Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        }, "myThread7");
        myThread7.start();


        // 睡眠状态的线程调用interrupt()时会抛出InterruptedException, 并且清除中断标记
        myThread7.interrupt();
    }
}
