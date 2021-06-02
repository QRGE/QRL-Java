package qr.Java.DataStructure.List.Queue;

import qr.Java.DataStructure.List.LinkedList.DoubleLinkedList;

import java.util.Arrays;

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

    // 尾部入队同Deque的enQueue
    public void enQueueRear(E element){
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    // 头部出队同Deque的deQueue
    public E deQueueFront(){
        E frontElement = elements[front];
        elements[front] = null;
        // 实际的1位置处索引为新的front值
        front = index(1);
        size--;
        return frontElement;
    }

    // 从队列的头部增加元素
    public void enQueueFront(E element){
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    // 从队列的末尾删除元素
    public E deQueueRear(){
        int realIndex = index(size - 1);
        E element = elements[realIndex];
        elements[realIndex] = null;
        size--;
        return element;
    }

    // 获取队列头部的元素
    public E front(){
        return elements[front];
    }

    // 获取队列尾部的元素
    public E end(){
        return elements[index(size - 1)];
    }

    /**
     * 自动扩容: 将原来的数组A排序后放入新的数组B中, 然后将B赋值给elements, B的自动扩容量为原来的1.5倍
     * @param size elements的size(实际数据个数)
     */
    private void ensureCapacity(int size){
        int oldCapacity = elements.length;
        if (oldCapacity >= size) return;
        int newCapacity = oldCapacity + (size >> 1);
        E[] newELements = (E[])new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newELements[i] = elements[index(i)];
        }
        elements = newELements;
        front = 0;
    }

    // 索引映射, 获取元素的真实索引
    private int index(int index){
        index += front;
        return index - (index >= elements.length ? elements.length : 0);
    }

    // 为了方便测试写的toString, 正常情况下至少应该按照 头 → 尾 或 尾 → 头 的顺序写⑧
    @Override
    public String toString() {
        return "Capacity: " + elements.length + ", Size: " + size + ", Elements: " + Arrays.toString(elements);
    }
}
