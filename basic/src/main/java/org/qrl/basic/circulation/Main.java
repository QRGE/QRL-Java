package org.qrl.basic.circulation;

/**
 * 利用标签跳出双重循环
 * @Author: QR
 * @Date: 2021/7/22-11:59
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        int l1 = 10;
        int l2 = 10;
        // 设置一个标签
        flag:
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d:%d\n", i, j);
                if (i == 7 && j == 9){
                    break flag;
                }
            }
        }
    }
}
