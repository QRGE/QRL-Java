package qrl.juc.thread.AtomicClass;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用AtomicReference原子读写一个对象,
 */
public class Demo5_AtomicReference {

    // 可以理解成具有原子性的对象?
    static AtomicReference<String> atomicReference = new AtomicReference<>("Hello");

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                if (atomicReference.compareAndSet("Hello","NiHaoWa")){
                    System.out.println(Thread.currentThread().getName() + " Hello -> NiHaoWa");
                }
            }).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                if (atomicReference.compareAndSet("NiHaoWa","Hello")){
                    System.out.println(Thread.currentThread().getName() + " NiHaoWa -> Hello");
                }
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(atomicReference.get());
    }

}
