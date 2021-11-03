package org.qrl.util.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author QR
 * @Date 2021/10/30 9:47 PM
 */
public class MathTool {

    /**
     * 生成 1 到 range 之间的勾股数对
     * @param range 范围
     * @return 勾股数对
     */
    public static List<int[]> pythagoreanTriples(int range){
        if (range < 1) {
            return new ArrayList<>();
        }
        return IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}))
                .filter(t -> t[2] % 1 == 0)
                .map(d -> new int[]{(int) d[0], (int) d[1], (int) d[2]})
                .collect(Collectors.toList());
    }
}
