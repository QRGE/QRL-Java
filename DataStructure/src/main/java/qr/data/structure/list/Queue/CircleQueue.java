package qr.data.structure.list.Queue;

import java.util.Arrays;

/**
 * @author QR
 */
@SuppressWarnings("unchecked")
public class CircleQueue<E>{

    private int front = 0;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * 获取队列的头元素
     * @return 返回头元素
     */
    public E peek(){
        return elements[front];
    }

    public int size(){
        return size;
    }

    /**
     * 涉及到容量操作时都要注意取模, 且添加元素时要注意扩容问题
     * @param element 待添加的元素
     */
    public void enQueue(E element){
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    public E deQueue(){
        E frontElement = elements[front];
        elements[front] = null;
        // 实际的1位置处索引为新的front值
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * 清空所欲元素
     */
    public void clear(){
        Arrays.fill(elements, null);
        size = 0;
        front = 0;
    }

    /**
     * 自动扩容: 将原来的数组A排序后放入新的数组B中, 然后将B赋值给elements, B的自动扩容量为原来的1.5倍
     * @param size elements的size(实际数据个数)
     */
    private void ensureCapacity(int size){
        int oldCapacity = elements.length;
        if (oldCapacity >= size) {
            return;
        }
        int newCapacity = oldCapacity + (size >> 1);
        E[] temp = (E[])new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            temp[i] = elements[index(i)];
        }
        elements = temp;
        front = 0;
    }

    /**
     * 获取元素在数组中的真实索引
     * @param index 表面元素的位置
     * @return 实际元素在 elements 中的索引
     */
    private int index(int index){
        return (front + index) % elements.length;
    }

    @Override
    public String toString() {
        return "Capacity: " + elements.length + ", Size: " + size + ", Elements: " + Arrays.toString(elements);
    }
}
