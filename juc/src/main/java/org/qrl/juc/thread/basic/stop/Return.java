package org.qrl.juc.thread.basic.stop;

public class Return {

    public static void main(String[] args) throws InterruptedException {
        Thread thread7_2 = new Thread(() -> {
            int i = 0;
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    // 可以通过 return 的形式结束当前线程
                    return;
                }
                System.out.println(i++);
            }
        }, "thread7_2");
        thread7_2.start();
        // 让子弹飞一会
        Thread.sleep(20);

        // 20ms 计算机就能进行 10000 次左右的 print
        thread7_2.interrupt();
        System.out.println("Stop!");
    }
}
