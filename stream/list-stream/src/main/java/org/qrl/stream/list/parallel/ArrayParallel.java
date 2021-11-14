package org.qrl.stream.list.parallel;

import cn.hutool.core.util.NumberUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 针对数组的并行操作
 * @author qr
 * @date 2021/11/14 7:12 PM
 */
public class ArrayParallel {

    private final static int size = 10;

    /**
     * parallelSetAll(): 根据数组下标进行一次指定操作然后赋值, 操作改变的是数组本身
     */
    @Test
    public void parallelSetAll(){
        int[] numArray = new int[size];
        Arrays.parallelSetAll(numArray, i -> i*3);
        System.out.println(Arrays.toString(numArray));
    }

    /**
     *  parallelPrefix(): 将每一个元素替换为当前元素和其前驱元素的"和"，"和"是任意一个BinaryOperator。
     */
    @Test
    public void parallelPrefix(){
        double[] doubleArray = new double[size];
        Arrays.parallelSetAll(doubleArray, i -> i * 1.5);
        System.out.println(Arrays.toString(doubleArray));
        Arrays.parallelPrefix(doubleArray, Double::sum);
        System.out.println(Arrays.toString(doubleArray));
    }

    @Test
    public void parallelSort(){
        double[] doubleArray = new double[size];
        for (int i = 0; i < size; i++) {
            doubleArray[i] = NumberUtil.round(new Random().nextDouble(100), 2).doubleValue();
        }
        System.out.println(Arrays.toString(doubleArray));
        Arrays.parallelSort(doubleArray);
        System.out.println(Arrays.toString(doubleArray));
    }
}
