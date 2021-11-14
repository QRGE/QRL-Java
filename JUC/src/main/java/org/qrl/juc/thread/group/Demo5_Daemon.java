package org.qrl.juc.thread.group;

public class Demo5_Daemon {

    public static void main(String[] args) {
        ThreadGroup group1 = new ThreadGroup("group1");

        group1.setDaemon(true); // 设置为守护线程组, 暂时不知道有什么明确意义
        for (int i = 0; i < 3; i++) {
            new Thread(group1, ()->{
                for (int j = 0; j < 10; j++) {
                    System.out.println("Current Thread: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
