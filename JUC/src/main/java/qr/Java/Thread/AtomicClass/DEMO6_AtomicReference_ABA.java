package qr.Java.Thread.AtomicClass;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicReference 仅创建一个具有原子性的对象, 没有解决ABA问题
 * AtomicStampedReference 原子类中有一个整数标记stamp, 每次执行CAS操作时, 需要区比较它的版本, 即比较stamp值, 版本相同才会机型修改
 */
public class DEMO6_AtomicReference_ABA {
    private static final AtomicReference<String> atomicReference = new AtomicReference<>("Hello");

    // 利用标记解决ABA问题, 除了传入初始值之外还需要传入一个boolean类型的标记
    private static final AtomicMarkableReference<String> atomicMarkableReference = new AtomicMarkableReference<>("Hello", true);

    // 利用标记解决ABA问题, 除了传入初始值之外还需要传入一个int类型版本号
    private static final AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("Hello",0);

    @Test
    void AtomicStampedReference() throws InterruptedException {
        // 创建第一个线程, 先 Hello -> NiHaoWa, 再 NiHaoWa -> Hello
        Thread thread1 = new Thread(()->{
            atomicStampedReference.compareAndSet("Hello","NiHaoWa",atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + " --> " + atomicStampedReference.getReference());
            atomicStampedReference.compareAndSet("NiHaoWa","Hello",atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
        });

        Thread thread2 = new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet("Hello", "NiHaiHaoMa", stamp, stamp+1));
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(atomicStampedReference.getReference());
    }

    @Test
    void AtomicReferenceDemo() throws InterruptedException {
        // 创建第一个线程, 先 Hello -> NiHaoWa, 再 NiHaoWa -> Hello
        Thread thread1 = new Thread(()->{
            atomicReference.compareAndSet("Hello", "NiHaoWa");
            System.out.println(Thread.currentThread().getName() + " --> " + atomicReference.get());
            atomicReference.compareAndSet("NiHaoWa","Hello");
        });

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 这里输出了True, 说明AtomicReference认为ABA是可行的
            System.out.println(atomicReference.compareAndSet("Hello", "NiHaiHaoMa"));
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(atomicReference.get());
    }
}
