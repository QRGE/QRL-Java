package qr.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序：不是很懂
 * @Author qr
 * @Date 2022/5/2-18:11
 */
@SuppressWarnings("unused")
public class ShellSort<T extends Comparable<T>> extends Sort<T>{


    public static void main(String[] args) {
        Integer[] nums = {7, 4, 5, 8, 1, 3};
        SelectionSort<Integer> shellSort = new SelectionSort<>();
        shellSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Override
    protected void sort() {
        int h = 1;
        // h 值的修正
        while (h < array.length)
            h = 2 * h + 1;
        // 进行排序
        while (h >= 1) {
            // 第一个待插入元素为 h
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h; j-=h) {
                    if (cmp(j-h, j) > 0)
                        swap(j-h, j);
                    else
                        break;
                }
            }
            h = h / 2;
        }
    }
}
