package qr.Java.DataStructure.List.Queue;

import qr.Java.DataStructure.List.LinkedList.DoubleLinkedList;

public class Deque<E> {

    private final DoubleLinkedList<E> list = new DoubleLinkedList<>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public void enQueueRear(E element){
        list.add(element);
    }

    public void enQueueFront(E element){
        list.add(0, element);
    }

    public E deQueueFront(){
        return list.remove(0);
    }

    public E deQueueRear(){
        return list.remove(list.size() - 1);
    }

    public E front(){
        return list.get(0);
    }

    public E end(){
        return list.get(list.size() - 1);
    }
}
