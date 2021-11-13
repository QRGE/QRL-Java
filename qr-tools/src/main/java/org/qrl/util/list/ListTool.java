package org.qrl.util.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 列表工具, 可用于:
 * - 生成一些列表
 * @Author QR
 * @Date 2021/10/30 3:58 PM
 */
public class ListTool {

    private final static Random RANDOM = new Random();

    /**
     * 生成指定范围内的所有数字列表, 如果 start > end 则返回一个空List
     * @param start 开始
     * @param end 结束
     * @return 生成的数字列表, [start, end]
     */
    public static List<Integer> createIntNumList(Integer start, Integer end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * 随机生成 n 个 0 ～ bound 闭区间之间的整数
     * @param n 生成数量
     * @param bound 整数的范围
     * @return 生成的随机数列表
     */
    public static List<Integer> randomIntList(int n, int bound){
        ArrayList<Integer> numList = new ArrayList<>(n);
        while (n-- > 0) {
            numList.add(RANDOM.nextInt(bound));
        }
        return numList;
    }
}
