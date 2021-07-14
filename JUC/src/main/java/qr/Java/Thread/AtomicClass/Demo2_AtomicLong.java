package qr.Java.Thread.AtomicClass;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Demo2_AtomicLong {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                Indicator.getInstance().newRequestReceive();
                int num = new Random().nextInt();
                if (num % 2 == 0){
                    Indicator.getInstance().requestProcessSuccess();
                }else {
                    Indicator.getInstance().requestProcessFailure();
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("RequestCount: " + Indicator.getInstance().requestCount);
        System.out.println("SuccessCount: " + Indicator.getInstance().getSuccessCount());
        System.out.println("FailureCount: " + Indicator.getInstance().getFailureCount());
    }

    /**
     * 使用原子变量类定义一个计数器
     * 该计数器在整个程序中都可以使用,并且在所有的地方都是用一个计数器,这个计数器可以设计成单例的
     * 在实际的项目中可以把计数器存放到filter中
     */
    static class Indicator{

        private Indicator(){}

        private static final Indicator INSTANCE = new Indicator();

        public static Indicator getInstance(){
            return INSTANCE;
        }

        // 使用原子变量类保存请求总数, 成功数, 失败数
        private final AtomicLong requestCount = new AtomicLong(0);
        private final AtomicLong successCount = new AtomicLong(0);
        private final AtomicLong failureCount = new AtomicLong(0);

        public void newRequestReceive(){
            requestCount.incrementAndGet();
        }

        public void requestProcessSuccess(){
            successCount.incrementAndGet();
        }

        public void requestProcessFailure(){
            failureCount.incrementAndGet();
        }

        // 查看请求总数, 请求成功数, 请求失败数
        public long getRequestCount(){
            return requestCount.get();
        }

        public long getSuccessCount(){
            return successCount.get();
        }

        public long getFailureCount(){
            return failureCount.get();
        }
    }
}
