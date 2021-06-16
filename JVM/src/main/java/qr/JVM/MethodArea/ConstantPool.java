package qr.JVM.MethodArea;

// 常量池中的所有值都是通过索引获取, 其中 #n 表示其索引
public class ConstantPool {

    public static void main(String[] args) {
        // 下面的字符串可以在字节码常量池中看到, 其索引值为 #23
        System.out.println("I will be stored in constantPool");
    }
}
