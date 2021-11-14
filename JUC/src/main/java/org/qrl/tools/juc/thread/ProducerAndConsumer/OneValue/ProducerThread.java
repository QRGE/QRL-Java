package org.qrl.tools.juc.thread.ProducerAndConsumer.OneValue;

public class ProducerThread extends Thread{

    private Value value;

    public ProducerThread(Value value){
        this.value = value;
    }

    @Override
    public void run() {
        while (true){
            value.setValue();
        }
    }
}