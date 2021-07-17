package qr.data.structure.tree;

import java.util.Comparator;

/**
 * @Author: QR
 * @Date: 2021/7/16-17:23
 */
public class BalanceBinarySearchTree<E> extends BinarySearchTree<E>{

    public BalanceBinarySearchTree() {
        super();
    }

    public BalanceBinarySearchTree(Comparator<E> comparator) {
        super(comparator);
    }

    protected void rotateRight(Node<E> grand){
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
    protected void rotateLeft(Node<E> grand){
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
    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
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
    }

    protected void rotate(
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
        // 创建d的左子树b a <- b -> c
        Node<E> dLeft = setTree(b, a, c);
        // 创建d的右子树f e <- f -> g
        Node<E> dRight = setTree(f, e, g);
        // 设置d的左右子树
        setTree(d, dLeft, dRight);
    }

    protected Node<E> setTree(Node<E> rNode, Node<E> leftNode, Node<E> rightNode){
        rNode.left = leftNode;
        if (leftNode != null){
            leftNode.parent = rNode;
        }
        rNode.right = rightNode;
        if (rightNode != null) {
            rightNode.parent = rNode;
        }
        return rNode;
    }
}
