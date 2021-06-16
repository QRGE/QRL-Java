package qr.JVM.MethodArea;

public class GlobalVariable {

    public static void main(String[] args) {
        Num num = null;

        // 即使是空引用也可以访问类变量
        System.out.println(num.a);
        num.b = 3;
        System.out.println(num.b);
    }
}

// 通过查看Num的字节码文件可以看到全局常量a已经被写进字节码文件中
class Num{

    // 字节码文件中通过ConstantValue: X 确定其值
    public final static int a = 1;
    // 不是全局常量(没有final static)则没有在字节码中确定值(毕竟静态变量还是可以改变的)
    public static int b = 2;
}
