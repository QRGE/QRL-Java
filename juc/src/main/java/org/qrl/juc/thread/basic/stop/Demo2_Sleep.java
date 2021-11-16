package org.qrl.juc.thread.basic.stop;

/**
 * 在 run 方法中结合 isInterrupt() 和 return/break/抛出异常等方式停止线程
 */
public class Demo2_Sleep {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                System.out.println("Begin");
                Thread.sleep(200000);
                System.out.println("End");
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted! " + Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        }, "thread");
        thread.start();

        // SLEEP状态的线程调用interrupt()时会抛出InterruptedException, 并且清除中断标记
        thread.interrupt();
    }
}
