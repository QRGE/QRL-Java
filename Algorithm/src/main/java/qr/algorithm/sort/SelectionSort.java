package qr.algorithm.sort;

/**
 * 选择排序: 找到序列中最大的元素, 然后与最末尾的元素交换位置
 * 查找时间复杂度：最好, 最坏, 平均的时间复杂度都是O(n^2),
 * 交换时间复杂度：O(n)
 * 空间复杂度: O(1)
 * @Author: QR
 * @Date: 2021/7/27-17:45
 */
@SuppressWarnings("unused")
public class SelectionSort<T extends Comparable<T>> extends Sort<T>{

    @Override
    public void sort() {
        for (int end = array.length - 1; end > 0 ; end--) {
            // 0 每次比较开始取 index=0 的位置, 下面遍历就从 index=1 开始
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(maxIndex, begin) <= 0) {
                    maxIndex = begin;
                }
            }
            swap(maxIndex, end);
        }
    }
}
