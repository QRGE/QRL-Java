package org.qrl.tools.juc.thread.ProducerAndConsumer.OneValue.Pattern;


import org.qrl.tools.juc.thread.ProducerAndConsumer.OneValue.ConsumerThread;
import org.qrl.tools.juc.thread.ProducerAndConsumer.OneValue.ProducerThread;
import org.qrl.tools.juc.thread.ProducerAndConsumer.OneValue.Value;

/**
 * More Producer To More Customer
 */
public class MoreToMore {

    public static void main(String[] args) {
        Value value = new Value();
        ProducerThread producer1 = new ProducerThread(value);
        ProducerThread producer2 = new ProducerThread(value);
        ProducerThread producer3 = new ProducerThread(value);
        ConsumerThread consumer1 = new ConsumerThread(value);
        ConsumerThread consumer2 = new ConsumerThread(value);
        ConsumerThread consumer3 = new ConsumerThread(value);

        // 可能全部的进程都进入等待状态
        // p1 -> p2.wait() -> p3.wait() -> p1.wait() -> c1 -> c2.wait() -> c3.wait() -> c1.wait()
        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
