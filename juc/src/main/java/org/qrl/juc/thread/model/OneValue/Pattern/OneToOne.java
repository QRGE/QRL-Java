package org.qrl.juc.thread.model.OneValue.Pattern;


import org.qrl.juc.thread.model.OneValue.ConsumerThread;
import org.qrl.juc.thread.model.OneValue.ProducerThread;
import org.qrl.juc.thread.model.OneValue.Value;

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
