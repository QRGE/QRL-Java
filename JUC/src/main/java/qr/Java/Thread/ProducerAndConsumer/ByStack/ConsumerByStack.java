package qr.Java.Thread.ProducerAndConsumer.ByStack;

public class ConsumerByStack extends Thread{

    private final MyStack stack;

    public ConsumerByStack(MyStack stack){
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true){
            stack.pop();
        }
    }
}
