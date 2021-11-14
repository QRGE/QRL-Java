package org.qrl.stream.list.infinite;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 无限流
 * @Author QR
 * @Date 2021/11/1 9:53 AM
 */
public class InfiniteStream {

    /**
     * 利用 iterate 按照规律创造无限流
     */
    @Test
    public void iterateTest(){
        List<Integer> numList = Stream.iterate(1, n -> n * 2)
                .limit(10)
                .collect(Collectors.toList());
        numList.forEach(System.out::println);
    }

    /**
     * 借助 generate() 根据传入的函数生成无限流
     */
    @Test
    public void generateTest(){
        Random random = new Random();
        List<Integer> randomNumList = Stream.generate(()-> random.nextInt(10))
                .limit(10)
                .collect(Collectors.toList());
        randomNumList.forEach(System.out::println);
    }

    /**
     * 借助无限流生成斐波那契数列
     */
    @Test
    public void FibonacciSequenceTest(){
        List<Integer> list = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(list.toArray()));
    }

}
