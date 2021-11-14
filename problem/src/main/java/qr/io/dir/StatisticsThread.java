package qr.io.dir;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class StatisticsThread implements Runnable{

    private final DirSize dirSize;
    private final String dirPath;
    private final ReentrantLock lock;
    private final CountDownLatch latch;

    public StatisticsThread(DirSize dirSize, String dirPath, ReentrantLock lock, CountDownLatch latch) {
        this.dirSize = dirSize;
        this.dirPath = dirPath;
        this.lock = lock;
        this.latch = latch;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            dirSize.add(FileUtils.sizeOfDirectory(new File(dirPath)));
        }finally {
            lock.unlock();
            latch.countDown();
        }
    }
}
