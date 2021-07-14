package qr.Java.Thread.Lock.IntrinsicLock.Synchronized;

// 脏读: 出现读取属性值出现了一些意外, 读取的是中间的值, 而不是修改之后的值
// 出现脏读的原因: 对共享数据的修改与共享数据的读取不同步
// 解决办法: 不仅要对修改数据的代码块同步, 还要对读取数据的代码块同步
public class Demo7_DirtyRead {

    public static void main(String[] args) throws InterruptedException {
        PublicValue publicValue = new PublicValue();
        MyThread1 myThread1 = new MyThread1(publicValue);
        myThread1.start();

        Thread.sleep(1000);
        System.out.println(publicValue.getValues());
    }

    static class MyThread1 extends Thread{
        private final PublicValue publicValue;
        public MyThread1 (PublicValue publicValue){
            this.publicValue = publicValue;
        }

        @Override
        public void run(){
            publicValue.setValues("LiSi","LiSi123");
        }
    }

    static class PublicValue{
        private String name = "ZhangSan";
        private String pwd = "123456";

        public synchronized String getValues(){
            return Thread.currentThread().getName() + " --> name: " + name + ", pwd" +  pwd;
        }

        public synchronized void setValues(String name, String pwd){
            this.name = name;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pwd = pwd;
            System.out.println(Thread.currentThread().getName() + " -- > setName: " + name + ", setPWD: " + pwd);
        }
    }
}
