package org.qrl.juc.thread.basic.stop;

/**
 * 首次调用 interrupt() 会设置 Thread 的 interrupt = true
 * 如果 interrupt == true 则 interrupt() 会设置 interrupt = false 并 clearInterruptEvent() (从名字理解就是从清楚中断事件)
 */
public class Demo1_interrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    // 可以通过 return 的形式结束当前线程
                    return;
                }
                System.out.println(i++);
            }
        }, "thread");
        thread.start();
        // 让子弹飞一会
        Thread.sleep(20);

        // 20ms 计算机就能进行 10000 次左右的 print
        thread.interrupt();
        System.out.println("Stop!");
    }
}
