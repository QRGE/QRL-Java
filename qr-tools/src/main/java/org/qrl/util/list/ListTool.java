package org.qrl.util.list;

import org.qrl.entity.bean.Apple;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 列表工具, 可用于:
 * - 生成一些列表
 * @Author QR
 * @Date 2021/10/30 3:58 PM
 */
public class ListTool {

    private final static Random RANDOM = new Random();

    private static Integer COUNT = 1;

    /**
     * 生成 n 个随机的苹果
     * @param n 生成苹果的数量
     * @return 苹果列表
     */
    public static List<Apple> createAppleList(int n){
        return Stream.generate(ListTool::createApple).limit(n).collect(Collectors.toList());
    }

    private static Apple createApple(){
        Apple apple = new Apple();
        apple.setId(COUNT++);
        apple.setPrice(RANDOM.nextDouble(100));
        apple.setWeight(RANDOM.nextDouble(20));
        // 暂时只知道这个品种
        apple.setType("红富士");
        return apple;
    }

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
}
