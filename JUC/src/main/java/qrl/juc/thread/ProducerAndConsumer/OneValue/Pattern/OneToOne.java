package qrl.juc.thread.ProducerAndConsumer.OneValue.Pattern;


import qrl.juc.thread.ProducerAndConsumer.OneValue.ConsumerThread;
import qrl.juc.thread.ProducerAndConsumer.OneValue.ProducerThread;
import qrl.juc.thread.ProducerAndConsumer.OneValue.Value;

/**
 * One Producer to One Customer
 */
public class OneToOne {

    public static void main(String[] args) {
        Value value = new Value();
        ProducerThread producer = new ProducerThread(value);
        ConsumerThread consumer = new ConsumerThread(value);

        producer.start();
        consumer.start();
    }
}
