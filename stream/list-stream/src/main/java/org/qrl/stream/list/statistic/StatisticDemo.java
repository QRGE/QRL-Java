package org.qrl.stream.list.statistic;

import org.junit.jupiter.api.Test;
import org.qrl.util.list.ListTool;

import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 将对应的流转换成基本类型的流后可以使用对应的 summaryStatistic 方法获取对流的统计值:
 * - 最大, 最小, 平均, 总数, 流个数
 * @author qr
 * @date 2021/11/12 4:11 PM
 */
public class StatisticDemo {

    private final static List<Integer> numList = ListTool.randomIntList(100,10000);

    @Test
    public void statistic(){
        IntSummaryStatistics statistics = numList.stream()
                .mapToInt(n -> n)
                .summaryStatistics();
        System.out.printf("numList.sum: %d, average: %f, max: %d, min: %d, count: %d",
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMax(),
                statistics.getMin(),
                statistics.getCount());
    }
}
