package qr.algorithm.sort;

import java.util.Arrays;

/**
 * 将序列不断分割成两个子序列，分割到不能到分割为止(只有一个元素)，将相邻的两个子序列合并成一个有序序列，重复这个过程
 * 归并排序的时间复杂度未 O(nlogn)
 * 但是需要额外的空间复杂度
 * 归并排序稳定
 * @Author: QR
 * @Date: 2021/7/28-20:55
 */
@SuppressWarnings("unused")
public class MergeSort<T extends Comparable<T>> extends Sort<T>{

    public static void main(String[] args) {
        Integer[] nums = {7, 4, 5, 8, 1, 3};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private T[] tempArray;

    @SuppressWarnings("unchecked")
    @Override
    protected void sort() {
        tempArray = (T[]) new Comparable[array.length];
        sort(0, array.length-1);
    }

    /**
     * 对 [begin, end) 范围的数据进行正常排序
     * @param begin 开始索引
     * @param end 结束索引
     */
    private void sort(int begin, int end) {
        if(end <= begin) {
            return;
        }
        int mid = (begin + end) / 2;
        // 将数组分割成不可分割的序列
        sort(begin, mid);
        sort(mid+1, end);
        // 进行排序后合并
        merge(begin, mid, end);
    }

    /**
     * 将 [begin, mid] 和 (mid, end] 范围的序列合并成一个有序序列
     */
    private void merge(int begin, int mid, int end) {
        int leftStart = begin;
        int rightStart = mid + 1;
        // 记录数组的覆盖位置index
        int index = begin;
        // 挪动数组
        while (leftStart <= mid && rightStart <= end) {
            if (cmp(array[leftStart], array[rightStart]) <= 0){
                tempArray[index++] = array[leftStart++];
            }else { // 左边数组还没挪完, 即使右边数组挪完了结束了也需要将左边的数组挪过去
                tempArray[index++] = array[rightStart++];
            }
        }
        // 检测未完全挪动完的数组
        // 左侧
        while (leftStart <= mid) {
            tempArray[index++] = array[leftStart++];
        }
        // 右侧
        while (rightStart <= end) {
            tempArray[index++] = array[rightStart++];
        }
        for (int i = begin; i <= end; i++) {
            array[i] = tempArray[i];
        }
    }
}
