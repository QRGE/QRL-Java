package qrl.stream.collector;

import org.junit.jupiter.api.Test;
import org.qrl.util.math.NumTool;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 收集器的三大作用:
 * - 将流元素归约和汇总为一个值
 * - 元素分组
 * - 元素分区
 * @Author QR
 * @Date 2021/11/3 5:29 PM
 */
public class CollectorSample {

    private final static List<Integer> numList = NumTool.intNumList(1, 100);

    @Test
    public void summingInt(){
        // statistics 是统计类, 里面包含了最大值， 最小值， 平均值，总和， 列表size
        IntSummaryStatistics statistics = numList.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Avg: " + statistics.getAverage());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Count: " + statistics.getCount());
    }
}