package qr.basic.util.scanner;

import java.util.Scanner;

/**
 * System.in表示获取从控制台中输入的值
 * scannerObj的常用API:
 *      next(): 获取控制台输入的字符串, 知道遇到一个空格符或换行符
 *      nextXX(): 获取从控制台输入的内容并转换为XX类型, 例如nextInt(), nextDouble()等
 *      nextLong(): 获取从控制台输入的内容, 内容可以包含空格, 直到输入换行符
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println(name);

        String name2 = sc.nextLine();
        System.out.println(name2);
        sc.close();
    }
}
