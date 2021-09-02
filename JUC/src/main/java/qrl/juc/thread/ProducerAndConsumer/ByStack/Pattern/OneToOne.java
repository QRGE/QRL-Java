package qrl.juc.thread.ProducerAndConsumer.ByStack.Pattern;


import qrl.juc.thread.ProducerAndConsumer.ByStack.ConsumerByStack;
import qrl.juc.thread.ProducerAndConsumer.ByStack.MyStack;
import qrl.juc.thread.ProducerAndConsumer.ByStack.ProducerByStack;

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
