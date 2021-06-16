package qr.Java.Basic.InstanceOf;

/**
 * a instance b 用于查看对象a是否为类,接口b的一个实例
 *      当a为类b的一个实例, 或b的子类的实例, 或a是接口b的一个实现对象时, 返回true
 */
public class InstanceofDemo {

    public static void main(String[] args) {
        int i = 0;
        // System.out.println(i instanceof Integer); a必须是一个引用
        Integer num = 1;
        System.out.println(num instanceof Integer);

        // 规定如果a为null则返回false
        System.out.println(null instanceof Object);
    }
}
