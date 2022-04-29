package org.qrl.basic.array;

import java.util.Arrays;

/**
 * @author qr
 * @date 2022/4/29 17:26
 */
public class Array {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3, 4};
        b = a;
        // 可以看到数组的引用还是可以直接替换的
        System.out.println(Arrays.toString(b));
    }
}
