package qr.data.structure.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author: QR
 * @Date: 2021/7/25-13:54
 */
public class BinaryHeapTests {

    @Test
    public void binaryHeapTest(){
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(1);
        heap.add(3);
        heap.add(2);
        heap.add(4);
        System.out.println(heap.get());
        System.out.println(heap.remove());
        System.out.println(heap.get());
        heap.replace(70);
        Assertions.assertEquals(heap.get(), Integer.valueOf(70));
    }
}
