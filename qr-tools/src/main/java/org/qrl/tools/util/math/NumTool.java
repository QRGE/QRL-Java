package org.qrl.tools.util.math;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author QR
 * @Date 2021/11/7 9:59 PM
 */
@SuppressWarnings("unused")
public class NumTool {

    /**
     * 生成 start 到 end 之间的闭区间整数列表
     * @param start 开始数字
     * @param end 结束数字
     * @return start 到 end 之间的整数列表
     */
    public static List<Integer> intNumList(int start, int end){
        return IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * 创建 2 到 n 之间的素数列表
     * @param n 指定的范围
     * @return 2～n 之间的素数列表
     */
    public static List<Integer> primeList(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(NumTool::checkPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * 判断某个数是不是质数
     * @param n 待判断的数
     * @return 判断结果
     */
    public static boolean isPrime(int n){
        return checkPrime(n);
    }

    private static boolean checkPrime(int n){
        //  只需要判断到平方根之前
        int candidateRoot = (int) Math.sqrt(n);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidateRoot % i == 0);
    }
}
