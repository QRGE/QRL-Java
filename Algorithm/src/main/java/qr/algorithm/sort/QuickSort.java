package qr.algorithm.sort;

/**
 * 以升序排序为例，快速排序以某个数为基准，将排序的数组分成基准数 a，左序列 arr1，右序列 arr2，其中 arr1 都比 a 小，arr2 都比 a 大，
 * 再分别对 arr1 和 arr2 重复这个过程
 * 快速排序的时间复杂度为 O(nlogn)
 * 快速排序不稳定
 * @Author qr
 * @Date 2022/5/3-01:27
 */
@SuppressWarnings("unused")
public class QuickSort<T extends Comparable<T>> extends Sort<T>{

    @Override
    protected void sort() {
        int begin = 0, end = array.length;
        sort(array, begin, end);
    }

    private void sort(T[] array, int begin, int end) {
        if (begin <= end) return;
        // 将 array 分成两个自组，左子序 arr1，右子序 arr2
        int standard = partition(array, begin, end);
        // 让 arr1 有序
        sort(array, begin, --standard);
        // 让 arr2 有序
        sort(array, ++standard, end);
    }

    private int partition(T[] array, int begin, int end) {
        T boundary = array[begin];
        int left = begin;
        int right = end + 1;
        while (true) {
            // 找到第一个比 boundary 小的数
            while (cmp(boundary, array[--right]) > 0)
                if (right == begin) break;
            // 从左往右找到第一个比 boundary 大的数
            while (cmp(boundary, array[++left]) < 0)
                if (left == end) break;
            if (left >= right) {
                break;
            }else {
                swap(left, right);
            }
        }
        swap(begin, left);
        return left;
    }
}
