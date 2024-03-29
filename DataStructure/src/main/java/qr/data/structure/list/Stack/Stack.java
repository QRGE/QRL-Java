package qr.data.structure.list.Stack;

import qr.data.structure.list.ArrayList.ArrayList;

/**
 * 利用动态链表实现Stack, 借助动态链表的add和remove方法
 * @param <E> Stack存储数据的类型
 * 为了不暴露父类的接口, 采用组合的方式(整一个成员变量)给Stack类调用ArrayList的各种方法
 */
public class Stack<E>{

    private final ArrayList<E> list = new ArrayList<>();

    public void push(E element){
        list.add(element);
    }

    public E pop(){
        return list.remove(list.size() - 1);
    }

    public E peek(){
        return list.get(list.size() - 1);
    }
}
