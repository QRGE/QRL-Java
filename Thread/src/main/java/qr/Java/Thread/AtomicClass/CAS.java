package qr.Java.Thread.AtomicClass;

/**
 * CAS(Compare And Swap)即在把数据更新到主内存之前, 再次读取主内存变量的值
 * 如果再次读取的值与期望值(操作起始读取的值)一样就更新，就可以实现更新(即可以防止初始值被其他线程改变的情况)
 */
public class CAS {

    public static void main(String[] args) {
        CASCounter casCounter = new CASCounter();
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(casCounter.incrementAndGet())).start();
        }
    }

    static class CASCounter{

        volatile private long value;

        public long getValue(){
            return value;
        }

        private boolean compareAndSwap(long expectedValue, long newValue){
            synchronized (this){
                if (value == expectedValue){
                    value = newValue;  // 原始值和期望值相等才把newValue赋予value
                    return true;
                }else {
                    return false;
                }
            }
        }

        public long incrementAndGet(){
            long oldValue;
            long newValue;
            do {
                oldValue = value;
                newValue = oldValue + 1;
            }while (!compareAndSwap(oldValue, newValue));
            return newValue;
        }
    }
}
