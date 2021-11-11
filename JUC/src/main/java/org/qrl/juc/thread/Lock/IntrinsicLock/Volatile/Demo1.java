package org.qrl.juc.thread.Lock.IntrinsicLock.Volatile;

// volatile可以强制线程从公共内存中读取变量的值， 而不是从工作内存中读取
// volatile可以保证数据的可见性, 不能保证数据的原子性
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        new Thread(printString::printStringMethod).start();

        // main线程中1秒钟之后再修改continuePrint
        Thread.sleep(1000);
        System.out.println("Main线程中修改打印标志");
        printString.setContinuePrint(false);
    }

    static class PrintString{
        private volatile boolean continuePrint = true;

        public void setContinuePrint(boolean continuePrint){
            this.continuePrint = continuePrint;
        }

        public void printStringMethod(){
            System.out.println(Thread.currentThread().getName() + ", Begin...");
            while (continuePrint){
                // 如果没有volatile关键字, 子线程可能无法读取到main线程修改的continuePrint属性从而进入死循环
            }
            System.out.println(Thread.currentThread().getName() + ", End...");
        }
    }
}
