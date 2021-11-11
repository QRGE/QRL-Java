package org.qrl.juc.thread.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ???
 */
public class WorkStealingPoolDemo {

    public static void main(String[] args) {
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
    }
}
