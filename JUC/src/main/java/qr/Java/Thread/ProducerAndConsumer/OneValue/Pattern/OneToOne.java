package qr.Java.Thread.ProducerAndConsumer.OneValue.Pattern;


import qr.Java.Thread.ProducerAndConsumer.OneValue.ConsumerThread;
import qr.Java.Thread.ProducerAndConsumer.OneValue.ProducerThread;
import qr.Java.Thread.ProducerAndConsumer.OneValue.Value;

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
