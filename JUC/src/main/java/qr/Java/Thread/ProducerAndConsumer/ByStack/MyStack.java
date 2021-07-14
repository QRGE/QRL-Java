package qr.Java.Thread.ProducerAndConsumer.ByStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * producer - consumer 操作栈模式
 * producer生产的数据都放到栈里
 * consumer每次都从栈取数据
 */
public class MyStack {

    private final List<String> list = new ArrayList<>();
    private static final int MAX_CAPACITY = 10;

    public synchronized void push(){
        // list >= MAX_CAPACITY时进入等待状态
        while (list.size() >= MAX_CAPACITY){
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // list有容量时添加一个数据
        try {
            String data = "date: " + new Random().nextInt(100);
            System.out.println(Thread.currentThread().getName() + " add: " + data);
            Thread.sleep(1000);
            list.add(data);
            this.notifyAll(); // 防止假死状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void pop(){
        while (list.size() == 0){
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " get: " + list.remove(0));
        this.notifyAll(); // 同样防止假死状态
    }
}
