package qr.Java.dataStructure.Tree;

import qr.Java.dataStructure.Tree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: QR
 * @Date: 2021/7/5-14:18
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements IBinarySearchTree<E>, BinaryTreeInfo {

    private int size;

    private Node<E> root;

    private final Comparator<E> comparator;

    /**
     * 节点类, 作为BST的节点保存数据
     * @param <E> 节点保存数据的类型
     */
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent){
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        public boolean hasTwoChildNode() {
            return left != null && right != null;
        }
    }

    public abstract static class Visitor<E> {

        /**
         * 用于保存visit的运行结果
         */
        boolean result = true;

        /**
         * 提供遍历BST的回调函数
         * @param element BST的元素
         * @return 如果返回true则继续执行, false则停止执行
         */
        protected abstract boolean visit(E element);
    }

    /**
     * predecessor: 前驱节点, 中序遍历中某个节点的前一个节点即为前驱节点
     * 针对BST, 某个节点的前驱节点如果存在, 必然是其左子树的最大值的节点
     * @param node 待求前驱节点的节点
     * @return 求得的前驱节点
     */
    private Node<E> predecessor(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> p;
        // 左子节点不为空的情况
        if (node.left != null) {
            p = node.left;
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        // 左节点为空的情况, 根据中序排列规则只能向父节点找
        p = node;
        while (node.parent != null && node == node.parent.left) {
            p = p.parent;
        }
        return p.parent;
    }

    /**
     * 找某个节点的后继节点
     * @param node 待查询后继节点的节点
     * @return 找到的后继节点
     */
    private Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> p;
        // 右子节点不为空的情况
        if (node.right != null) {
            p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        // 右节点为空的情况, 根据中序排列规则只能向父节点找
        p = node;
        while (node.parent != null && node == node.parent.right) {
            p = p.parent;
        }
        return p.parent;
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree(){
        this.comparator = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        Node<E> node = root;
        Node<E> parent = null;
        int compareResult = 0;
        while (node != null) {
            compareResult = compare(element, node.element);
            parent = node;
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
        Node<E> addNode = new Node<>(element, parent);
        if (compareResult > 0){
            parent.right = addNode;
        } else {
            parent.left = addNode;
        }
        size++;
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
        // 度为1的节点
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

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    private void elementNotNullCheck(E element) {
        if (element == null){
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 前序遍历BST, 根节点 -> 左子树 -> 右子树
     * @param visitor 回调函数的实现
     */
    public void preorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        preorderTraversal(root, visitor);
    }

    /**
     * 前序遍历一个节点
     * @param node 待遍历的节点
     * @param visitor 回调函数的实现
     */
    private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        if (!visitor.result){
            return;
        }
        visitor.result = visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }

    /**
     * 中序遍历BST, 左子树 -> 根节点 -> 右子树
     * @param visitor 提供回调函数实现
     */
    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(Node<E> node, Visitor<E> visitor){
        if (node == null || !visitor.result){
            return;
        }
        inorderTraversal(node.left, visitor);
        if (!visitor.result) {
            return;
        }
        visitor.result = visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    /**
     * 后续遍历BST: 左子树 -> 右子树 -> 根节点
     * @param visitor 回调函数的实现
     */
    public void postorderTraversal(Visitor<E> visitor){
        if (visitor == null) {
            return;
        }
        postorderTraversal(root, visitor);
    }

    /**
     * 后续遍历一个节点
     * @param node 待遍历的节点
     * @param visitor 回调函数的实现
     */
    private void postorderTraversal(Node<E> node, Visitor<E> visitor){
        if (node == null || !visitor.result){
            return;
        }
        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        if (!visitor.result){
            return;
        }
        visitor.result = visitor.visit(node.element);
    }

    public void levelOrderTraversal(Visitor<E> visitor){
        if (root == null && visitor == null) {
            return;
        }
        Queue<Node<E>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while (!nodeList.isEmpty()){
            Node<E> node = nodeList.poll();

            // 回调函数, 提供操作node节点元素的接口, 并接收回调函数的返回值, 如果为false则结束遍历
            visitor.result= visitor.visit(node.element);
            if (!visitor.result){
                return;
            }

            if (node.left != null){
                nodeList.offer(node.left);
            }
            if (node.right != null) {
                nodeList.offer(node.right);
            }
        }
    }

    /**
     * 获取BST的高度
     * @return BST高度值
     */
    public int height(){
        // return heightByRecursion
        return heightByIteration(root);
    }

    /**
     * 返回某个节点的层数
     * @param node 求层数的节点
     * @return 层数
     */
    private int heightByIteration(Node<E> node){
        if (node == null) {
            // 空树为0层
            return 0;
        }

        int height = 0;
        // levelSize用于记录每层节点的个数
        int levelSize = 1;
        Queue<Node<E>> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while (!nodeList.isEmpty()){
            node = nodeList.poll();
            // 每次取出一个节点时levelSize--
            levelSize--;
            if (node.left != null){
                nodeList.offer(node.left);
            }
            if (node.right != null) {
                nodeList.offer(node.right);
            }
            // levelSize==0时说明本层节点已经取完,
            if (levelSize == 0) {
                // 队列中剩下的节点即为下一层的节点
                levelSize = nodeList.size();
                height++;
            }
        }
        return height;
    }

    private int heightByRecursion(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(heightByRecursion(node.left), heightByRecursion(node.right));
    }

    /**
     * 利用遍历查看该BST是否为完全二叉树
     * @return 否为完全二叉树的结果
     */
    public boolean isComplete() {
        if (root == null) {
            return false;
        }
        Queue<Node<E>> nodes = new LinkedList<>();
        nodes.offer(root);
        Node<E> node;
        boolean leafNode =false;
        while (!nodes.isEmpty()){
            node = nodes.poll();
            // 判断是否需要为叶子节点
            if (leafNode && !node.isLeaf()) {
                return false;
            }

            // 注意判断顺序
            if (node.left != null) {
                nodes.offer(node.left);
            }
            // 左为空右不为空的情况, 不是完全二叉树返回false
            else if (node.right != null) {
                return false;
            }

            if (node.right !=null) {
                nodes.offer(node.right);
            }
            // node.left = null && node.right != null / node.left != null $$ node.right == null 的情况
            // 只有接下来的节点都是叶子节点该BST才为完全二叉树, 设置一个判断标记
            else {
                leafNode = true;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        toString(root, builder, "");
        return builder.toString();
    }

    private void toString(Node<E> node, StringBuilder builder, String pre){
        if (node == null) {
            return;
        }
        builder.append(pre).append(node.element).append("\n");
        toString(node.left, builder, pre + "[L]");
        toString(node.right, builder, pre + "[R]");
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

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }
}
