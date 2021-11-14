package org.qrl.stream.list;

import org.junit.jupiter.api.Test;
import org.qrl.tools.util.list.ListTool;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 原始类型流:
 * - IntStream
 * - DoubleStream
 * - LongStream
 * @Author QR
 * @Date 2021/10/30 3:47 PM
 */
public class TypeStream {

    private static final List<Integer> intList = ListTool.randomIntList(30, 200);

    @Test
    public void intStreamDemo() {
        // 具有类型的流有更多的规约操作, 例如此处的 sum
        int sum = intList.stream().mapToInt(n -> n).sum();
        System.out.println(sum);
    }

    @Test
    public void boxed() {
        List<String> strList = intList.stream()
                .mapToInt(n -> n)
                // boxed() 可以把一个原始类型的流转换成一般的流
                .boxed().map(n -> n + "")
                .collect(Collectors.toList());
        System.out.println(strList);
    }

    @Test
    public void rangeClosed() {
        // 借助 IntStream 生成的连续数列
        List<Integer> numList = ListTool.createIntNumList(100, -100);
        numList.forEach(System.out::println);
    }
}
