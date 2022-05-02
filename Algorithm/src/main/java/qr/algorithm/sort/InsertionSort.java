package qr.algorithm.sort;

import java.util.Arrays;

/**
 * 排序原理： 将序列分成已排序和未排序两部分，刚开始可以默认0为已排序，然后取出未排序的第一个元素插入到已排序序列的合适的位置中，重复这个过程
 * - 插入到已排序序列中的方法可以进行优化
 *
 * 插入排序的时间复杂度跟逆序对成正比关系
 * - 最坏、平均的时间复杂度为 O(n^2)
 * - 最好的时间复杂度为 O(n)
 * 空间复杂度为O(1)
 * 是稳定的算法
 * 和冒泡排序相比, *插入排序每次取值进行比较的序列都是有序的
 *
 * 想象一下打扑克时整理手牌的过程
 * @Author: QR
 * @Date: 2021/7/28-15:13
 */
@SuppressWarnings("unused")
public class InsertionSort<T extends Comparable<T>> extends Sort<T>{

    public static void main(String[] args) {
        Integer[] nums = {6, 9, 4, 5, 1};
        new InsertionSort<Integer>().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Override
    protected void sort() {
        for (int begin  = 1; begin < array.length; begin++) {
            int cur = begin;
            // 这里相当于在有序列表中冒泡插入一个元素
            while (cur > 0 && cmp(cur, cur-1) < 0){
                swap(cur, cur-1);
                cur--;
            }
        }
    }

    /**
     * 少了一些交换操作
     */
    public void sort2(){
        for (int begin  = 1; begin < array.length; begin++) {
            int cur = begin;
            T v = array[cur];
            // 相对于swap少了几次交换操作
            while (cur > 0 && cmp(v, array[cur - 1]) < 0){
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }

    /**
     * 结合二分搜索可以再优化比较次数
     */
    public void sort3(){
        for (int begin  = 1; begin < array.length; begin++) {
            int insertIndex = search(begin);
            T v = array[begin];
            for (int i = begin - 1; i >= insertIndex ; i--) {
                array[i+1] = array[i];
            }
            array[insertIndex] = v;
        }
    }

    /**
     * 利用传入的 index 查找插入排序中 index 位置的元素应该插入在 [begin, index) 中的位置
     * @param index index
     * @return 插入的索引
     */
    private int search(int index){
        T target = array[index];
        int begin = 0;
        int end = index;
        while (begin < end){
            // [begin, end)
            int mid = (begin + end) >> 1;
            if (cmp(target, array[mid]) < 0){
                end = mid;
            }else { // target >= array[mid]
                begin = mid + 1;
            }
        }
        return begin;
    }
}
