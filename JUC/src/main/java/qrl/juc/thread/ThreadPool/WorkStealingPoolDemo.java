package qrl.juc.thread.ThreadPool;

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
