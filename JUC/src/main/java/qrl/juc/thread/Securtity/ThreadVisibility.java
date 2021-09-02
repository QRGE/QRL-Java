package qrl.juc.thread.Securtity;

import java.util.Random;

public class ThreadVisibility {


    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        new Thread(myTask).start();
        Thread.sleep(1000);
        /*
         * 当main线程调用cancel()方法时, myTask的toCancel变量修改为true, 可能存在子线程看不到main线程对toCancel的修改而继续执行
         * 造成这种情况的原因:
         *    JIT即时编译器可能会对run方法中的while进行优化:
         *    if(!toCancel){
         *        while(true){
         *            if(doSomething)...
         *        }
         *    }
         *    可能和计算机的存储系统有关, 假设分别有两个CPU内核运行main线程和子线程,一个main线程无法立即读取另一个CPU内核的数据
         */
        myTask.cancel();
    }

    static class MyTask implements Runnable{

        private boolean toCancel = false;

        @Override
        public void run() {
            while (!toCancel){
                if (doSomething()){
                    System.out.println("Working...");
                }
            }

            if (toCancel){
                System.out.println("Mission is cancelled...");
            }else {
                System.out.println("Mission complete!");
            }
        }

        private boolean doSomething() {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        public void cancel(){
            toCancel = true;
            System.out.println("Cancel mission!");
        }
    }
}
