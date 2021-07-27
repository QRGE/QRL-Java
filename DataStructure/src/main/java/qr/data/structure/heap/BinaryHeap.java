package qr.data.structure.heap;

import java.util.Comparator;

/**
 * 二叉堆: 通过改变二叉堆的比较册策略可以设置最大堆和最小堆
 * @Author: QR
 * @Date: 2021/7/25-13:05
 */
@SuppressWarnings("all")
public class BinaryHeap<E> extends AbstractHeap<E>{

    private E[] elements;
    private int size;
    private Comparator<E> comparator;
    private final static int DEFAULT_CAPACITY = 10;

    public BinaryHeap(Comparator<E> comparator){
        super(comparator);
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap(){
        super(null);
    }

    public BinaryHeap(E[] elements, Comparator comparator){
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            // 深拷贝
            for (int i = 0; i < capacity; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    public BinaryHeap(E[] elements){
        this(elements, null);
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    /**
     * 让 index 位置的元素上溢
     * @param index 上溢元素的索引
     */
    private void siftUp(int index){
        E self = elements[index];
        while (index > 0) {
            // 获取父节点的索引
            int parentIndex = (index- 1) / 2;
            E parent = elements[parentIndex];
            if (compare(self, parent) <=0){
                break;
            }
            // 将父元素存储在 index 位置
            elements[index] = elements[parentIndex];
            // 重复赋值交换后的 index
            index = parentIndex;
        }
        elements[index] = self;
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();
        E oldTop = elements[0];
        // 将数组最后一个元素赋值给 index=0 后再删除最后一个元素
        elements[0] = elements[size - 1];
        elements[size - 1] = null;
        // 删除后数组数量减少, size--需要放到下溢之前, 否则会有下溢中的size和实际的size不符合
        size--;
        // 根元素进行下溢
        siftDown(0);
        return oldTop;
    }

    /**
     * 下溢
     * @param index 待下溢的节点元素
     */
    private void siftDown(int index){
        // 非叶子节点的个数
        int half = size >> 1;
        E oldTop = elements[index];
        // 保证 index 处的节点为非叶子节点
        while (index < half){
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];
            // 如果有右子节点, 将左子节点和右子节点进行比较后选取下溢比较对象
            int rightChildIndex = childIndex + 1;
            if (rightChildIndex < size && compare(elements[rightChildIndex], child) > 0){
                childIndex = rightChildIndex;
                child = elements[rightChildIndex];
            }
            if (compare(oldTop, child) >= 0){
                break;
            }
            elements[index] = child;
            index = childIndex;
        }
        elements[index] = oldTop;
    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E top = null;
        // size=0时只替换不删除
        if (size == 0) {
            elements[0] = element;
            size++;
            return top;
        }else { // 如果 size != 0 直接将第一个元素替换成 element 后再进行下溢操作
            top = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return top;
    }

    /**
     * 批量建堆, 即传入一个集合数据并将其转换成堆, 批量建堆有两种方法:
     * - 自上而下的上滤: 类似于增加
     * - 自下而上的下滤: 类似于删除
     */
    private void heapify(){
        // 自上而下的上滤
        for (int i = 0; i < size; i++) {
            siftUp(i);
        }
        // 自下而上的上滤
        for (int i = (size >> 1) - 1; i>=0; i--) {
            siftDown(i);
        }
    }

    private void emptyCheck(){
        if (size == 0){
            throw new IndexOutOfBoundsException("Heap is empty.");
        }
    }

    private void elementNotNullCheck(E element){
        if (element == null){
            throw new IllegalArgumentException("Element must not be null.");
        }
    }

    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        // 扩容为原来的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}
