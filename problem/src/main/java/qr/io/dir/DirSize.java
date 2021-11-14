package qr.io.dir;

/**
 * 统计一台电脑多个磁盘的大小, 现有C, D, E三个硬盘
 * 要求:
 * 第1个线程统计C盘的大小
 * 第2个线程统计D盘的大小
 * 第3个县城统计E盘的大小
 * 第4个线程计算各个盘大小的总和
 */
public class DirSize {

    private volatile long totalSize;

    public void add(long size){
        totalSize += size;
    }

    public long getTotalSize() {
        return totalSize;
    }
}
