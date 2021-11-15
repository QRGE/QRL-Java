package org.qrl.juc.thread.model.OneValue;

public class ConsumerThread extends Thread{

    private Value value;

    // 和Producer传入同一个对象
    public ConsumerThread(Value value){
        this.value = value;
    }

    @Override
    public void run() {
        while (true){
            value.getValue();
        }
    }
}
