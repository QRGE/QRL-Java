package qr.data.structure.list.Queue;

import qr.data.structure.heap.BinaryHeap;

import java.util.Comparator;

/**
 * 优先级队列: 根据优先级高低进行出队
 * 利用二叉堆实现优先级队列
 *
 * java.uti.Priority Java官方的优先级队列
 * @Author: QR
 * @Date: 2021/7/26-14:08
 */
@SuppressWarnings("ALL")
public class PriorityQueue<E> {

    private final BinaryHeap<E> heap;

    public PriorityQueue(Comparator<E> comparator){
        this.heap = new BinaryHeap<>(comparator);
    }

    public PriorityQueue(){
        this(null);
    }

    public int size(){
        return heap.size();
    }

    public void offer(E element){
        heap.add(element);
    }

    public E poll(){
        return heap.remove();
    }

    public E peek(){
        return heap.get();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public void clear() {
        heap.clear();
    }
}
