package org.qrl.tools.basic.circulation;

/**
 * @Author: QR
 * @Date: 2021/7/22-11:59
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        int l1 = 10;
        int l2 = 10;
        flag:
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + " : " + j);
                if (i == 1 && j == 3){
                    break flag;
                }
            }
        }
    }
}
