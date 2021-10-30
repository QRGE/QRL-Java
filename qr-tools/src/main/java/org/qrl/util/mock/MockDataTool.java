package org.qrl.util.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 产生些测试用数据
 * @Author QR
 * @Date 2021/10/29 10:28 PM
 */
public class MockDataTool {

    private static final Random random = new Random();

    /**
     * 随机产生 0 ～ bound 闭区间内的 n 个随机数
     * @param n 随机数个数, n <= 0 直接返回 null
     * @param bound 范围的最大值
     * @return 产生的随机列表
     */
    public static List<Integer> randomIntegerNumList(Integer n, Integer bound){
        ArrayList<Integer> integers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            integers.add(random.nextInt(bound));
        }
        return integers;
    }


}
