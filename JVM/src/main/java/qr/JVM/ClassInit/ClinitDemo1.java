package qr.JVM.ClassInit;

/**
 * Initialization阶段会保证父类的 clinit 方法先执行
 */
public class ClinitDemo1 {

    static class SuperClass{
        public static int A = 3;
        static {
            A = 4;
        }
    }

    static class SubClass extends SuperClass{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(SubClass.B);
    }
}
