package org.qrl.tools.juc.thread.ZProblems.StatisticsDirSize;

public class TotalThread implements Runnable{

    private final DirSize dirSize;

    public TotalThread(DirSize dirSize){
        this.dirSize = dirSize;
    }

    @Override
    public void run() {
        System.out.println("TotalDirSize: " + dirSize.getTotalSize());
    }
}
