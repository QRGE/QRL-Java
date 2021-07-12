package qr.Java.dataStructure.Tree;

import java.util.Comparator;

/**
 * @Author: QR
 * @Date: 2021/7/5-14:18
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E> extends BinaryTree<E> implements IBinarySearchTree<E>{

    /**
     * 比较器, 用于设定树节点元素的比较规则
     */
    private final Comparator<E> comparator;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree(){
        this.comparator = null;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = createNode(element, null);
            size++;
            afterAdd(root);
            return;
        }
        Node<E> node = root;
        Node<E> pNode = null;
        int compareResult = 0;
        while (node != null) {
            compareResult = compare(element, node.element);
            pNode = node;
            if (compareResult > 0){
                node = node.right;
            }else if(compareResult < 0){
                node = node.left;
            }else {
                // 如果传入的自定义对象, 确保每次传入对象的信息都为element
                // 当设置自定义对象的比较方式时, 通常只会选取某个域的值作为比较, 为保证接收到element的其他域的值, 每次将当前node的element替换
                // 按需决定
                node.element = element;
                return;
            }
        }
        Node<E> addNode = createNode(element, pNode);
        if (compareResult > 0){
            pNode.right = addNode;
        } else {
            pNode.left = addNode;
        }
        size++;
        afterAdd(addNode);
    }

    /**
     * 删除包含指定数据的节点
     * @param element 指定的数据
     */
    @Override
    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) {
            return;
        }
        // 删除度为2的节点: 找到节点的前驱或后继节点替换原来的位置
        if (node.hasTwoChildNode()){
            Node<E> sNode = successor(node);
            node.element = sNode.element;
            // 将Node引用sNode对象, 后面只需要删除Node即可
            node = sNode;
        }
        // 删除度为1或0的节点的情况
        Node<E> replaceNode = node.left != null ? node.left : node.right;
        // 度为1的节点则删除自己(父节点指向自己的子节点)
        if (replaceNode != null) {
            replaceNode.parent = node.parent;
            // 根节点的情况
            if (node.parent == null) {
                root = replaceNode;
            }else if (node == node.parent.left) {
                node.parent.left = replaceNode;
            }else if (node == node.parent.right) {
                node.parent.parent = replaceNode;
            }
        }
        // 叶子节点&&根节点
        else if (node.parent == null) {
            root = null;
        }
        // 叶子节点且非根节点
        else {
            if (node == node.parent.left){
                node.parent.left = null;
            }
            if (node == node.parent.right) {
                node.parent.right = null;
            }
        }
        size--;
    }

    /**
     * 查找值为指定值的节点
     * @param element 指定的数据
     * @return 查找到的元素
     */
    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        // 没找到
        return null;
    }

    /**
     * 查询是否由指定元素的节点
     * @param elements 待查询是否包含的元素
     * @return 返回查询结果
     */
    @Override
    public boolean contains(E elements) {
        return node(elements) != null;
    }

    /**
     * 判断某个元素是否为空
     * @param element 待判断是否为空的元素
     */
    private void elementNotNullCheck(E element) {
        if (element == null){
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 比较传入两个参数的大小
     * @param e1 参数1
     * @param e2 参数2
     * @return 返回0表示e1==e2, 返回大于1表示e1 > e2, 返回小于1表示e1 < e2
     */
    private int compare(E e1, E e2){
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        // 如果没有传入比较器, 则强制转换成Comparable类型惊醒比较, 无法比较则报错
        return ((Comparable<E>)e1).compareTo(e2);
    }

    protected void afterAdd(Node<E> node){}
}
