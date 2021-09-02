package qrl.basic.character;

/**
 * Character类API
 * - boolean isJavaIdentifierPart(char ch): 判断某个字符是否为标识符
 * @Author: QR
 * @Date: 2021/7/12-18:56
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Character.isJavaIdentifierPart('&'));
        System.out.println(Character.isJavaIdentifierPart('_'));
    }
}
