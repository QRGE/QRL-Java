package org.qrl.juc.thread.group;

public class Demo4_interrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            System.out.println("Current Thread: " + Thread.currentThread());
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        };

        ThreadGroup group1 = new ThreadGroup("group1");
        String threadName;
        for (int i = 1; i <= 5; i++) {
            threadName = "myThread" + i;
            Thread thread = new Thread(group1, r , threadName);
            thread.start();
        }
        Thread.sleep(500);
        // 如果中断睡眠中的线程, 会产生中断异常, 同时会清除中断标志
        group1.interrupt();
    }
}
