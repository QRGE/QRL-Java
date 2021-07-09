package qr.Java.dataStructure.List.Queue;

import qr.Java.dataStructure.List.LinkedList.DoubleLinkedList;

import java.util.Arrays;

/**
 * @author QR
 */
@SuppressWarnings("unchecked")
public class CircleDeque<E> {

    private int front = 0;
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    private final DoubleLinkedList<E> list = new DoubleLinkedList<>();

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    /**
     * 尾部入队
     * @param element 待添加的元素
     */
    public void enQueueRear(E element){
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    /**
     * 头部出队
     * @return 出队的元素
     */
    public E deQueueFront(){
        E frontElement = elements[front];
        elements[front] = null;
        // 实际的1位置处索引为新的front值
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * 从队列的头部增加元素
     * @param element 待添加的元素
     */
    public void enQueueFront(E element){
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    /**
     * 从队列的末尾删除元素
     * @return 队尾删除的元素
     */
    public E deQueueRear(){
        int realIndex = index(size - 1);
        E element = elements[realIndex];
        elements[realIndex] = null;
        size--;
        return element;
    }

    /**
     * 获取队列头部的元素
     * @return 队列头部元素
     */
    public E front(){
        return elements[front];
    }

    /**
     * 获取队列尾部的元素
     * @return 队列尾部元素
     */
    public E end(){
        return elements[index(size - 1)];
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
     * 索引映射, 获取元素的真实索引
     * @param index 元素的排列顺序
     * @return 元素在 elements 中的真实索引
     */
    private int index(int index){
        index += front;
        return index - (index >= elements.length ? elements.length : 0);
    }

    @Override
    public String toString() {
        return "Capacity: " + elements.length + ", Size: " + size + ", Elements: " + Arrays.toString(elements);
    }
}
