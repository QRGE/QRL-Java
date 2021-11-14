package org.qrl.juc.thread.relation.ProducerAndConsumer.ByStack.Pattern;


import org.qrl.juc.thread.relation.ProducerAndConsumer.ByStack.ConsumerByStack;
import org.qrl.juc.thread.relation.ProducerAndConsumer.ByStack.MyStack;
import org.qrl.juc.thread.relation.ProducerAndConsumer.ByStack.ProducerByStack;

/**
 * One producer to one consumer
 */
public class OneToOne {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        ProducerByStack producer = new ProducerByStack(myStack);
        ConsumerByStack consumer = new ConsumerByStack(myStack);

        producer.start();
        consumer.start();
    }
}
