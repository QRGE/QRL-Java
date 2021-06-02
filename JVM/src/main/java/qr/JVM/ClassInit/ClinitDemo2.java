package qr.JVM.ClassInit;

/**
 * clinit 方法只会执行一次, 即一个类只需要被加载一次
 */
public class ClinitDemo2 {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " Start!");
            new DeadThread();
            System.out.println(Thread.currentThread().getName() + " End!");
        };

        Thread t1 = new Thread(r, "Thread1");
        Thread t2 = new Thread(r, "Thread2");

        t1.start();
        t2.start();
    }
}

class DeadThread{
    static {
        System.out.println(Thread.currentThread().getName() + " initialize...");
    }
}
