package qrl.juc.thread.ThreadGroup;

public class Demo2 {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup group1 = new ThreadGroup("Group1");

        Runnable r = ()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("Current Thread: " + Thread.currentThread());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread myThread1 = new Thread(mainGroup, r, "myThread1");
        Thread myThread2 = new Thread(group1, r, "myThread2");
        myThread1.start();
        myThread2.start();

        // active会返回当前线程组及子线程组中的活跃线程数量, 此处4个活跃线程: main myThread1 myThread2 垃圾回收器
        System.out.println("The active threads in mainGroup: " + mainGroup.activeCount());
        System.out.println("The active threads in Group1: " + group1.activeCount());

        // main线程组的夫线程组是system
        System.out.println("The parent ThreadGroup of mainGroup: " + mainGroup.getParent());
        System.out.println("The parent ThreadGroup of group1: " + group1.getParent());

        // 列出线程组及子线程组中的所有活跃线程
        mainGroup.list();
    }
}
