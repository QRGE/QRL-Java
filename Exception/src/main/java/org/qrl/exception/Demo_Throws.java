package org.qrl.exception;

/**
 * THROWS 用于抛出一个方法可能抛出的异常
 * 处理方法
 * - try-catch
 * - 继续 THROWS
 * @Author qr
 * @Date 2022/5/11-19:12
 */
@SuppressWarnings("all")
public class Demo_Throws {

    public static void main(String[] args){
        try {
            solution1();
        }catch (ClassNotFoundException e) {
            System.out.println("类未找到");
        }
    }

    /**
     * 继续 throws 异常
     */
    public static void solution1() throws ClassNotFoundException{
        fun();
    }

    /**
     * try-catch 处理
     */
    public static void solution2() throws ClassNotFoundException{
        try {
            fun();
        }catch (ClassNotFoundException e) {
            System.out.println("类未找到2");
        }
    }

    public static void fun() throws ClassNotFoundException {
        Class.forName("org.qrl.exception.QRException1");
    }
}
