package qr.Java.dataStructure.List.LinkedList;

import qr.Java.dataStructure.List.AbstractList;

// java.util.LinkedList<E> java官方的链表是利用双向链表实现的
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
        return node(index).element; // 通过node获取对应的节点后再获取对应的element
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
        rangeCheckForAdd(index);    // 检查index是否超出范围
        if (index == size){
            Node<E> preNode = last;                                     // 直接在末尾添加newNode, 运来的末尾节点变成了newNode的prev
            Node<E> newNode = new Node<>(element, null, preNode);       // 创建newNode
            last = newNode;                                             // last指向newNode
            if (preNode == null){
                first = newNode;
            }else {
                preNode.next = newNode;                                     // preNode的next需要指向newNode
            }



        } else {
            Node<E> nextNode = node(index);                             // 在某个位置加入一个新的节点后, 原来的节点被挤到后面, 故取名nextNode
            Node<E> prevNode = nextNode.prev;                           // 原来节点的前一个节点依然是newNode的前一个节点, 故取名preNode
            Node<E> newNode = new Node<>(element, nextNode, prevNode);  // 创建待添加的新节点newNode, newNode的next指向nextNode, prev指向prevNode
            if (prevNode == null) {
                first = newNode;                                        // 如果在index=0处添加节点, first应该指向newNode
            }else {
                prevNode.next = newNode;                                // prevNode的next需要指向newNode
            }

            nextNode.prev = newNode;                                    // nextNode的prev也需要指向newNode
        }
        size++;                      // 添加元素后节点个数加一
    }

    /**
     * 删除指定索引处的节点
     * @param index 待节点的索引
     * @return 被删除节点的数据element
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);                    // 检查删除index的范围
        Node<E> deletedNode = node(index);    // 被删除的节点
        Node<E> prevNode = deletedNode.prev;  // 获取被删除的头节点的前一个节点prevNode
        Node<E> nextNode = deletedNode.next;  // 获取被删除的头节点的有一个节点nextNode
        if (prevNode == null){                // 删除头节点的情况
            first = nextNode;                 // nextNode变成了新的first
        }else {
            prevNode.next = nextNode;         // 其他情况
        }
        if (nextNode == null){                // 删除尾节点的情况
            last = prevNode;                  // preNode成为的新的last节点
        }else {
            nextNode.prev = prevNode;         // 其他情况
        }
        E oldElement = deletedNode.element;   // 获取被删除节点的element, 用于返回
        size--;                               // 删除数据一个数据后size-1
        return oldElement;                    // 返回被删除的节点的数据element
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
        last = null;   // null同first, 双向指针的话设置first和last设置为0后, 剩下的环形节点也会被回收(不是gc root对象, 暂时不懂2021/4/1)
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
                node = node.next; // 刚开始写成first.next了,纯sb(⊙﹏⊙)
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    // 节点对象
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
                builder.append("( " + prev.element);
            }else {
                builder.append("( Null");
            }
            builder.append("_").append(element).append("_");
            if (next != null){
                builder.append(next.element + " )");
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
