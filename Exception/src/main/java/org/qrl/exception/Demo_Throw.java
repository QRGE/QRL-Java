package org.qrl.exception;

/**
 * @Author qr
 * @Date 2022/5/11-19:20
 */
public class Demo_Throw {

    public static void main(String[] args) {
        solution1();
    }

    public static void solution1() {
        fun();
    }

    public static void fun() {
        throw new QRRuntimeException("错了");
    }
}
