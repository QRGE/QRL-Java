package org.qrl.stream.list.parallel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.qrl.tools.constant.TimeUnit;
import org.qrl.tools.util.list.ListTool;
import org.qrl.tools.util.time.TimeTool;

import java.util.List;

/**
 * @author qr
 * @date 2021/11/14 3:50 PM
 */
public class ParallelStream {

    /**
     * 只有数据足够大、每个数据处理管道花费的时间足够多时，并行化处理才有意义
     */
    @Test
    public void parallelTest(){
        List<Integer> numList = ListTool.integerList(1, 100000000);
        long time1 = System.nanoTime();
        int serialWay = numList.stream().mapToInt(n -> n).sum();
        long time2 = System.nanoTime();
        System.out.println("SerialWay: " + TimeTool.nsDifference(time1, time2, TimeUnit.ms) + " ms");
        long time3 = System.nanoTime();
        int parallelWay = numList.parallelStream().mapToInt(n -> n).sum();
        long time4 = System.nanoTime();
        System.out.println("ParallelWay: " + TimeTool.nsDifference(time3, time4, TimeUnit.ms) + " ms");
        Assertions.assertEquals(serialWay, parallelWay);
    }
}
