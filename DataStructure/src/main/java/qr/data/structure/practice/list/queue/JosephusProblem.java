package qr.data.structure.practice.list.queue;

import qr.data.structure.list.AbstractList;

/**
 * @author QR
 */
@SuppressWarnings("unused")
public class JosephusProblem<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;
    private Node<E> current;

    /**
     * 获取到index位置节点的element
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
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * 充值current节点
     */
    public void reset(){
        current = first;
    }

    /**
     * 获得下一个节点的元素
     * @return 下一个节点的元素值
     */
    @SuppressWarnings("UnusedReturnValue")
    public E next(){
        if (current == null) {
            return null;
        }
        current = current.next;
        return current.element;
    }

    public E remove(){
        if (current == null) {
            return null;
        }
        Node<E> nextNode = current.next;
        E removeElement = remove(current);
        if (size==0){
            current = null;
        }else {
            current = nextNode;
        }
        return removeElement;
    }

    /**
     * 在指定索引处添加节点
     * @param index 指定索引
     * @param element 新添加节点的数据
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size){
            Node<E> preNode = last;
            Node<E> newNode = new Node<>(element, null, preNode);
            last = newNode;
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
        return remove(node(index));
    }

    @Override
    public void remove(E element) {
        remove(indexOf(element));
    }

    public E remove(Node<E> node){
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;
        if (prevNode == null){
            first = nextNode;
        }else {
            prevNode.next = nextNode;
        }
        if (nextNode == null){
            last = prevNode;
        }else {
            nextNode.prev = prevNode;
        }
        E oldElement = node.element;
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

    /**
     * 清空节点元素
     */
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

    /**
     * 节点对象
     * @param <E> 节点对象元素的类型
     */
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

    static void josephus(){
        JosephusProblem<Integer> linkedlist = new JosephusProblem<>();
        int num = 8;
        for (int i = 1; i <= num; i++) {
            linkedlist.add(i);
        }
        linkedlist.reset();
        while (!linkedlist.isEmpty()){
            linkedlist.next();
            linkedlist.next();
            System.out.println(linkedlist.remove());
        }
    }

    public static void main(String[] args) {
        josephus();
    }
}
