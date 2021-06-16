package qr.JVM.PCRegister;


/**
 * 通过反编译查看源码, Code部分的 n:XX 中的n代表程序指令(偏移步数)
 */
public class PCRegisterDemo {

    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        int k = i + j;

        String s = "abc";
        System.out.println(s);
    }
}
