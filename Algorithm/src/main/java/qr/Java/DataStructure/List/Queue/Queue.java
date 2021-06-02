package qr.Java.DataStructure.List.Queue;

import qr.Java.DataStructure.List.LinkedList.DoubleLinkedList;

/**
 * 队列: Queue, 只能在头尾两端进行操作的线性表
 * 队尾: rear, 只能从队尾添加元素, 一般叫做enQueue(入列)
 * 对头: front, 只能从对头移除元素, 一般叫做deQueue(出列)
 * 队列遵循先进先出原则: First In First Out, FIFO
 * front ... rear
 *
 * Java.util.LinkedList是Java官方提供的队列的实现类
 */
public class Queue<E>{

    private final DoubleLinkedList<E> list = new DoubleLinkedList<>();

    public int size(){
        return list.size();
    }

    public void enQueue(E element){
        list.add(element);
    }

    public E deQueue(){
        return list.remove(0);
    }

    public E front(){
        return list.get(0);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
