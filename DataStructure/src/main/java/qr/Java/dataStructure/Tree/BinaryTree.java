package qr.Java.dataStructure.Tree;

/**
 * @Author: QR
 * @Date: 2021/7/9-14:49
 */
public class BinaryTree<E> {

    private int size;

    private Node<E> root;

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
}
