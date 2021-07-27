package qr.topK;

import qr.data.structure.heap.BinaryHeap;

import java.util.Arrays;
import java.util.Random;

/**
 * 从 n 个整数中, 找出最大的前 K 个数 ( k << n)
 * - 快速排序 O(nlog(n))
 * - 二叉堆 O(nlog(K))
 * @Author: QR
 * @Date: 2021/7/25-16:55
 */
@SuppressWarnings("all")
public class Solution {

    private final static Integer DATA_SIZE = 10;
    private final static Integer[] DATA = new Integer[DATA_SIZE];

    static {
        Random random = new Random();
        for (int i = 0; i < DATA.length; i++) {
            DATA[i] = random.nextInt(100);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DATA));
    }

    public Integer[] findK(Integer[] data, Integer k){
        BinaryHeap<Integer> heap = new BinaryHeap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < data.length; i++) {
            // 前 K 个数添加到小顶堆
            if (heap.size() < k){
                heap.add(data[i]);
            }else if (data[i] > heap.get()){ // 如果是第 k+1 个数 > heap.get() 则 replace(k+1)
                heap.replace(data[i]);
            }
        }
        Integer[] result = new Integer[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.get();
            heap.remove();
        }
        return result;
    }
}
