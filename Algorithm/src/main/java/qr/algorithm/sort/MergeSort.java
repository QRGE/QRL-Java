package qr.algorithm.sort;

/**
 * 将序列不断分割成两个子序列, 分隔到不能到分隔位置(只有一个元素), 再不断成合并成一个有序序列
 * @Author: QR
 * @Date: 2021/7/28-20:55
 */
@SuppressWarnings({"unused", "unchecked"})
public class MergeSort<T extends Comparable<T>> extends Sort<T>{

    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    /**
     * 对 [begin, end) 范围的数据进行正常排序
     * @param begin 开始索引
     * @param end 结束索引
     */
    private void sort(int begin, int end) {
        int restrict = 2;
        if(end - begin < restrict) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
     * @param begin begin
     * @param mid mid
     * @param end end
     */
    @SuppressWarnings("ALL")
    private void merge(int begin, int mid, int end) {
        // leftStart leftEnd rightStart rightEnd
        int ls = 0, le = mid - begin;
        int rs = mid, re = end;
        // 记录数组的覆盖位置, now index
        int ni = begin;
        // 备份左半边的数组
        for (int i = ls; i < le; i++) {
            leftArray[i] = array[begin + i];
        }
        // 左边还没结束, 即使右边数组挪完了结束了也需要将左边的数组挪过去
        while (ls < le) {
            if (rs < re && cmp(leftArray[ls], array[rs]) <= 0){
                array[ni++] = leftArray[ls++];
            }else {
                array[ni++] = array[rs++];
            }
        }
    }
}
