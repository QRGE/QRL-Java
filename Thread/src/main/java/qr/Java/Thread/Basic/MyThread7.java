package qr.Java.Thread.Basic;

public class MyThread7 extends Thread{

    @Override
    public void run(){
        try {
            this.setName("MyThread7");
            long startTime = System.currentTimeMillis();
            Thread.sleep(2000);
            long endTime = System.currentTimeMillis();
            System.out.println("Run(), ThreadName: " + Thread.currentThread().getName() + ", Pass: " + (endTime - startTime));
        } catch (InterruptedException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread7 myThread7 = new MyThread7();
        long startTime = System.currentTimeMillis();
        myThread7.start();
        long endTime = System.currentTimeMillis();
        System.out.println("Main, pass: " + (endTime - startTime));
    }
}
