package org.qrl.io.dir;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        CountDownLatch latch = new CountDownLatch(3);

        DirSize dirSize = new DirSize();
        new Thread(new StatisticsThread(dirSize, "D:\\ZA", lock, latch), "ThreadA").start();
        new Thread(new StatisticsThread(dirSize, "D:\\ZB", lock, latch), "ThreadB").start();
        new Thread(new StatisticsThread(dirSize, "D:\\ZC", lock, latch), "ThreadC").start();

        latch.await(); // 当count见到0时latch才会被唤醒
        new Thread(new TotalThread(dirSize), "ThreadD").start();
    }
}
