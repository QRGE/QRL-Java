package qr.algorithm.sort;

/**
 * 冒泡排序: 不断对比数组中相邻的两个数据, 将大的数据往后挪
 * 最坏, 平均的时间复杂度 O(n^2)
 * 最好的时间复杂度 O(n), 即完全排序的数组, 只需要遍历一次
 * @Author: QR
 * @Date: 2021/7/27-16:09
 */
@SuppressWarnings("unused")
public class BubbleSort<T extends Comparable<T>> extends Sort<T>{

    @Override
    public void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin-1) < 0){
                    swap(begin, begin-1);
                }
            }
        }
    }

    /**
     * 优化1，可以提前跳出遍历
     */
    public void sort2(int[] nums){
        if (nums == null || nums.length < ARRAY_LIMIT){
            return;
        }
        for (int end = nums.length - 1; end > 0; end--) {
            // 在数组有序的情况下可以退出比较
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin-1) < 0){
                    swap(begin, begin-1);
                    sorted = false;
                }
            }
            // 某一次冒泡后已经排序好了，就不用继续遍历了
            if (sorted) {
                break;
            }
        }
    }

    /**
     * 优化2：记录需要冒泡排序的序列
     */
    public void sort3(int[] nums){
        if (nums == null || nums.length < ARRAY_LIMIT){
            return;
        }
        for (int end = nums.length - 1; end > 0; end--) {
            // 记录每一轮交换的最后一个位置, 可以识别部分已经排序数组部分
            // sortedIndex = 1 可以为完全有序的数组准备
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin-1) < 0){
                    swap(begin, begin-1);
                    sortedIndex = begin;
                }
            }
            // 0～sortedIndex 部分的列表才需要排序
            end = sortedIndex;
        }
    }
}
