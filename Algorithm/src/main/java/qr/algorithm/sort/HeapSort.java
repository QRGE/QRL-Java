package qr.algorithm.sort;

/**
 * 堆排序可以认为是选择排序的优化, 即利用二叉堆进行最大数据的选择,
 * 则时间复杂度从选择排序的 O(n^2) 优化到 O(nlogn)
 * 堆排序不是一个稳定的排序
 * @Author: QR
 * @Date: 2021/7/27-19:24
 */
@SuppressWarnings("unused")
public class HeapSort<T extends Comparable<T>> extends Sort<T>{

    private int heapSize;

    @Override
    public void sort() {
        // 让数组成为二叉堆, 自下而上的下溢
        heapSize = array.length;
        for (int i = (heapSize >> 1); i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1){
            // 交换堆顶元素和堆底元素后再 heapSize--, 这样即可进行升序排序
            swap(0, --heapSize);
            // 对 0 位置的元素进行下溢使 heapSize-- 后的数组符合二叉堆
            siftDown(0);
        }
    }

    private void siftDown(Integer index){
        T element = array[index];
        int half = heapSize >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            T child = array[childIndex];
            // 或者 childIndex + 1
            int rightChildIndex = (index << 1) + 2;
            if (rightChildIndex < heapSize && cmp(rightChildIndex, childIndex) > 0) {
                childIndex = rightChildIndex;
                child = array[childIndex];
            }
            if (cmp(index, childIndex) >= 0) {
                break;
            }
            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }
}
