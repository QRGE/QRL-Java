package org.qrl.juc.thread.model.ByStack.Pattern;


import org.qrl.juc.thread.model.ByStack.ConsumerByStack;
import org.qrl.juc.thread.model.ByStack.MyStack;
import org.qrl.juc.thread.model.ByStack.ProducerByStack;

/**
 * one producer to more consumer
 */
public class OneToMore {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        ProducerByStack producer = new ProducerByStack(myStack);
        producer.setName("Producer");
        ConsumerByStack consumer1 = new ConsumerByStack(myStack);
        consumer1.setName("Consumer1");
        ConsumerByStack consumer2 = new ConsumerByStack(myStack);
        consumer2.setName("Consumer2");
        ConsumerByStack consumer3 = new ConsumerByStack(myStack);
        consumer3.setName("Consumer3");

        // 所有的线程都处于等待状态(假死状态)
        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
