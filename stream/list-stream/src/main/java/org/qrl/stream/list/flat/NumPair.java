package org.qrl.stream.list.flat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 将两个数字列表的所有元素组成数对子
 * @Author QR
 * @Date 2021/10/28 11:42 PM
 */
public class NumPair {
    public static void main(String[] args) {
        List<Integer> numsList1 = Arrays.asList(1,2,3);
        List<Integer> numsList2 = Arrays.asList(4,5,6);
        List<int[]> numPairs = numsList1.stream()
                .flatMap(i -> numsList2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        for (int[] numPair : numPairs) {
            System.out.println(Arrays.toString(numPair));
        }
    }
}
