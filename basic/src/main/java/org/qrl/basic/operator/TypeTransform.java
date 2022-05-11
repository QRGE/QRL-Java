package org.qrl.basic.operator;

/**
 * @Author qr
 * @Date 2022/5/9-10:45
 */
public class TypeTransform {

    public static void main(String[] args) {
        int a = 1;
        long b = 2L;
//        a = a + b; 可以这样会报错
        // += 会自动进行强制类型转换
        a += b;
        System.out.println(a);
    }
}
