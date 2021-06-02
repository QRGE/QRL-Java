package qr.Java.Thread.ProducerAndConsumer.ByStack.Pattern;


import qr.Java.Thread.ProducerAndConsumer.ByStack.ConsumerByStack;
import qr.Java.Thread.ProducerAndConsumer.ByStack.MyStack;
import qr.Java.Thread.ProducerAndConsumer.ByStack.ProducerByStack;

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
