package org.qrl.basic.operator;

/**
 * 三目运算符在设置赋值基础类型的值前会自动进行类型转换
 * @Author: QR
 * @Date: 2021/7/19-14:22
 */
public class TernaryOperator {

    public static void main(String[] args) {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);
    }
}
