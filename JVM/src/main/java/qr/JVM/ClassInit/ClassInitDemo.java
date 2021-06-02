package qr.JVM.ClassInit;

public class ClassInitDemo {

    private static int num = 1;

    static {
        num = 2;
        // 在link阶段的准备步骤中num有初始值0所以可以赋值 num2 = 4, 此处先num2先有初始化值0, 再被赋值为4, 最后被赋值为2
        // num2可以在定义之前赋值(或叫改变其值), 但是无法在定义之前引用, 若引用会报错illegal forward reference
        num2 = 4;
    }

    private static int num2 = 3;

    public static void main(String[] args) {
        System.out.println(ClassInitDemo.num);
        System.out.println(ClassInitDemo.num2);
    }
}
