package qr.Java.Thread.Lock.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service {

    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private int num = 26;

    public void read(){
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " num: " + getNum());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "release lock");
            readWriteLock.readLock().unlock();
        }
    }

    public void write(int i){
        try {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " setNum: "  + i);
            setNum(i);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "release lock");
            readWriteLock.writeLock().unlock();
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
