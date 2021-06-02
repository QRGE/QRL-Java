package qr.JVM.StackStructure;

/**
 * 通过javap -v XX.class指令可以对字节码文件进行反编译
 */
public class StackStructureDemo {
    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        int k = i + j;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello");
    }
}
