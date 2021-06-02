package qr.Java.DataStructure.List.LinkedList;

import qr.Java.DataStructure.List.AbstractList;

/**
 * 增加了虚拟头节点
 * @param <E> 链表的类型
 */
public class SinglyLinkedList2<E> extends AbstractList<E> {

    private Node<E> first;

    public SinglyLinkedList2() {
        first = new Node<>(null, null);
    }

    /**
     * 获取到index位置节点的内容
     * @param index 待获取节点内容的位置
     * @return 对应节点位置的内容element
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 替换index位置节点的element
     * @param index 待设置的节点位置
     * @param element 待替换的数据element
     * @return 返回原来index位置节点的数据element
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);   // 获取到index位置的节点
        E oldElement = node.element;  // 获取原来节点的数据OldElement
        node.element = element;       // 替换掉原来节点的数据element -> OldElement
        return oldElement;            // 返回原来的数据OleElement
    }

    /**
     * 在指定索引处添加节点
     * @param index 指定索引
     * @param element 新添加节点的数据
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        Node<E> pre = index == 0 ? first : node(index - 1);            // 先获取到指定索引的前一个节点previous
        pre.next = new Node<>(element, pre.next);       // previous的next指向新的节点,而新的节点的next指向了原来previous的next
        size++;                                             // 增加元素个数
    }

    /**
     * 删除指定索引处的节点
     * @param index 待节点的索引
     * @return 被删除节点数据
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        // 假设被删除的节点为B,B的前一个节点为A,后一个节点为C
        Node<E> pre = index == 0 ? first : node(index-1);  // 获取A
        E oldElement = pre.next.element;      // 保存删除节点的数据B.element
        pre.next = pre.next.next;           // A.next指向B.next
        size--;
        return oldElement;
    }

    /**
     * 通过遍历获取第一个指定元素element的索引值
     * @param element 指定的元素
     * @return 指定元素的索引值
     */
    @Override
    public int indexOf(E element) {
        Node<E> node = first;                               // 获取first的节点用于遍历
        if (element == null){
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void remove(E element) {
        remove(indexOf(element));
    }

    // 清空节点
    @Override
    public void clear() {
        size = 0;      // 节点数设置成0
        first = null;  // first设置成null, 则原来存储在first引用的node会因为没有引用而被回收(具体看jvm相关内容吧,暂时还没学2021/3/21)
    }

    /**
     * 获取index位置对应的节点对象
     * @param index 节点位置
     * @return index位置的位置节点
     */
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next; // 刚开始写成first.next了,纯sb(⊙﹏⊙)
        }
        return node;
    }

    // 节点对象
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> node = first;
        stringBuilder.append("Size= ").append(size).append(", [ ");
        for (int i = 0; i < size; i++) {
            if(i != 0){
                stringBuilder.append(", ");
            }
            stringBuilder.append(node.element);
            node = node.next;
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
