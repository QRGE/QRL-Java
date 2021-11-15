package org.qrl.juc.thread.lock.IntrinsicLock.Synchronized;

// 选择 同步方法 还是 同步代码块 ?
// 同步代码块的锁的粒度高, 执行效率较低
public class Demo6 {

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        new Thread(demo6::longTimeTask).start();
        new Thread(demo6::longTimeTask).start();
    }

    public void longTimeTask(){
        System.out.println("Task Prepare...");
        try {
            Thread.sleep(5000); // 模拟准备工作时间, 暂停线程5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            System.out.println("同步开始");
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
            System.out.println("Task end...");
        }
    }
}
