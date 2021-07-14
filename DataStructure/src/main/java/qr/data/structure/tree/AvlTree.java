package qr.data.structure.tree;

import java.util.Comparator;

/**
 * @Author: QR
 * @Date: 2021/7/12-19:05
 */
public class AvlTree<E> extends BinarySearchTree<E> {

    private static class AvlNode<E> extends BinarySearchTree.Node<E>{

        /**
         * 默认节点的高度为1
         */
        int height = 1;

        public AvlNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>)right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>)right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AvlNode<E>)right).height;
            if (leftHeight > rightHeight) {
                return left;
            }
            if (leftHeight < rightHeight) {
                return right;
            }
            return isLeftChild() ? left : right;

        }
    }

    public AvlTree() {
        super();
    }

    public AvlTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AvlNode<>(element, parent);
    }

    /**
     * 增加节点后触发的函数, 用户平衡节点
     * @param node 新增的节点
     */
    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)){
                updateHeight(node);
            }else {
                toBalance(node);
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)){
                updateHeight(node);
            }else {
                // 相对于afterAdd需要一直判断是否为父节点是否失衡, 最坏情况时间复杂度为O(log n)
                toBalance(node);
            }
        }
    }

    /**
     * 判断某个节点是否平衡
     * @param node 待判断节点
     * @return 是否平衡的结果
     */
    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AvlNode<E>)node).balanceFactor()) <= 1;
    }

    /**
     * 更新节点的高度
     * @param node 待更新高度的节点
     */
    private void updateHeight(Node<E> node) {
        ((AvlNode<E>)node).updateHeight();
    }

    /**
     * 恢复节点的平衡
     * @param grand 待恢复平衡的节点
     */
    private void toBalance(Node<E> grand) {
        Node<E> parent = ((AvlNode<E>)grand).tallerChild();
        Node<E> node = ((AvlNode<E>)parent).tallerChild();
        if (parent.isLeftChild()){
            //LL
            if (node.isLeftChild()){
                rotateRight(grand);
            }
            else { // LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else {
            // RL
            if (node.isLeftChild()) {
                rotateRight(parent);
                rotateLeft(grand);
            } else { //RR
                rotateLeft(grand);
            }
        }
    }

    private void rotateRight(Node<E> grand){
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        // 即使是null也可以
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);
    }

    /**
     * 右旋转
     * @param grand 待旋转的节点
     */
    private void rotateLeft(Node<E> grand){
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        // 即使是null也可以
        grand.right = child;
        parent.left = grand;
        afterRotate(grand, parent, child);

    }

    /**
     * 旋转后的设置新的grand以及更新父节点和高度的代码一样, 抽取成方法
     * @param grand grand节点
     * @param parent parent节点
     * @param child child节点
     */
    private void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        // parent 设置成 newGrand
        parent.parent = grand.parent;
        if (grand.isLeftChild()){
            grand.parent.left = parent;
        }else if (grand.isRightChild()){
            grand.parent.right = parent;
        }else { // 根节点情况
            root = parent;
        }
        // 更新child的父节点
        if (child!=null){
            child.parent = grand;
        }
        // 更新grand的父节点
        grand.parent = parent;
        // 更新高度, 要先低再高
        updateHeight(grand);
        updateHeight(parent);
    }

    /**
     * 统一旋转情况
     */
    private void toBalance2(Node<E> grand) {
        Node<E> parent = ((AvlNode<E>)grand).tallerChild();
        Node<E> node = ((AvlNode<E>)parent).tallerChild();
        if (parent.isLeftChild()){
            // LL
            if (node.isLeftChild()){
                rotate(grand, node.left, node, node.right, parent, parent.right, grand, grand.right);
            }
            else { // LR
                rotate(grand, parent.left, parent, node.left, node, node.right, grand, grand.right);
            }
        } else {
            // RL
            if (node.isLeftChild()) {
                rotate(grand, grand.left, grand, node.left, node, node.right, parent, parent.right);
            } else { //RR
                rotate(grand, grand.left, grand, parent.left, parent, node.left, node.right, node);
            }
        }
    }

    /**
     * 统一情况的旋转
     * @param r 原来的根节点
     * @param a aNode
     * @param b bNode
     * @param c cNode
     * @param d dNode
     * @param e eNode
     * @param f fNode
     * @param g gNode
     */
    private void rotate(
            Node<E> r,
            Node<E> a, Node<E> b, Node<E> c,
            Node<E> d,
            Node<E> e, Node<E> f, Node<E> g) {
        // 设置d为根节点
        d.parent = r.parent;
        if (r.isLeftChild()){
            r.parent.left = d;
        }else if (r.isRightChild()){
            r.parent.right = d;
        }else { // 根节点
            root = d;
        }
        // 创建d的左子树a <- b -> c
        Node<E> dLeft = setTree(b, a, c);
        // 创建d的右子树 e <- f -> g
        Node<E> dRight = setTree(f, e, g);
        // 设置d的左右子树
        setTree(d, dLeft, dRight);
    }

    private Node<E> setTree(Node<E> rNode, Node<E> leftNode, Node<E> rightNode){
        rNode.left = leftNode;
        if (leftNode != null){
            leftNode.parent = rNode;
        }
        rNode.right = rightNode;
        if (rightNode != null) {
            rightNode.parent = rNode;
        }
        updateHeight(rNode);
        return rNode;
    }
}
