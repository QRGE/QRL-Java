package org.qrl.database.jdbc.demo;

/**
 * @author qr
 * @date 2022/1/4 22:31
 */
public class Change {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        int temp = b;
        b = a;
        a = temp;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
