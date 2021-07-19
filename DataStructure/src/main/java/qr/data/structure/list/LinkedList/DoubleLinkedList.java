package qr.data.structure.list.LinkedList;

import qr.data.structure.list.AbstractList;

/**
 * java.util.LinkedList 是利用双向链表实现的
 * @author QR
 */
public class DoubleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;

    /**
     * 获取到index位置节点的element
     * @param index 待获取节点内容的位置
     * @return 对应节点位置的内容element
     */
    @Override
    public E get(int index) {
        // 通过node获取对应的节点后再获取对应的element
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
        // 获取到index位置的节点
        Node<E> node = node(index);
        // 获取原来节点的数据OldElement
        E oldElement = node.element;
        // 替换掉原来节点的数据element -> OldElement
        node.element = element;
        return oldElement;
    }

    /**
     * 在指定索引处添加节点
     * @param index 指定索引
     * @param element 新添加节点的数据
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        // 再链表末尾添加元素
        if (index == size){
            Node<E> preNode = last;
            Node<E> newNode = new Node<>(element, null, preNode);
            last = newNode;
            // 添加第一个元素
            if (preNode == null){
                first = newNode;
            }else {
                preNode.next = newNode;
            }
        } else {
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> newNode = new Node<>(element, nextNode, prevNode);
            if (prevNode == null) {
                first = newNode;
            }else {
                prevNode.next = newNode;
            }
            nextNode.prev = newNode;
        }
        size++;
    }

    /**
     * 删除指定索引处的节点
     * @param index 待节点的索引
     * @return 被删除节点的数据element
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> deletedNode = node(index);
        Node<E> prevNode = deletedNode.prev;
        Node<E> nextNode = deletedNode.next;
        // 删除头节点, nextNode 变成了新的 first
        if (prevNode == null){
            first = nextNode;
        }else { // 正常情况, prevNode 的 next 指向了 nextNode
            prevNode.next = nextNode;
        }
        // 删除尾节点, preNode 成为的新的last节点
        if (nextNode == null){
            last = prevNode;
        }else { // 正常情况, nextNode 的 prev 指向 preNode
            nextNode.prev = prevNode;
        }
        E oldElement = deletedNode.element;
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
        Node<E> node = first;
        if (element == null){
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void remove(E element) {
        remove(indexOf(element));
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    /**
     * 获取index位置对应的节点对象
     * @param index 节点位置
     * @return index位置的位置节点
     */
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> node;
        if (index < (size >> 1)){
            node = first;
            for (int i = 0; i < index; i++) {
                // 刚开始写成first.next了,纯sb(⊙﹏⊙)
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> next, Node<E> prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            if (prev != null){
                builder.append("( ").append(prev.element);
            }else {
                builder.append("( Null");
            }
            builder.append("_").append(element).append("_");
            if (next != null){
                builder.append(next.element).append(" )");
            }else {
                builder.append("Null )");
            }
            return builder.toString();
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
            stringBuilder.append(node);
            node = node.next;
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
