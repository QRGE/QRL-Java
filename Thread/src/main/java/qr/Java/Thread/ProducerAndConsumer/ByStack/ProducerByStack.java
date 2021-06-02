package qr.Java.Thread.ProducerAndConsumer.ByStack;

public class ProducerByStack extends Thread{

    private final MyStack stack;

    public ProducerByStack(MyStack stack){
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true){
            stack.push();
        }
    }
}
