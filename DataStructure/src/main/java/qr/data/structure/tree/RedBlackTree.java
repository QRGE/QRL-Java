package qr.data.structure.tree;

import java.util.Comparator;

/**
 * @Author: QR
 * @Date: 2021/7/16-15:42
 */
@SuppressWarnings("UnusedReturnValue")
public class RedBlackTree<E> extends BalanceBinarySearchTree<E>{

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RedBlackTree(){
        super();
    }

    public RedBlackTree(Comparator<E> comparator){
        super(comparator);
    }

    /**
     * RbNode相对于BinaryTree的Node添加了color属性
     * - color: 设置节点的颜色
     * @param <E>
     */
    private static class RbNode<E> extends Node<E>{

        /**
         * color默认为红色可以让红黑树的性质尽快满足
         */
        boolean color = RED;

        public RbNode(E element, Node<E> parent) {
            super(element, parent);
        }

        /**
         * 方便打印出凸显红色
         * @return 凸显红色后的显示字符串
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (color == RED) {
                sb.append("R_");
            }
            if (color == BLACK){
                sb.append("B_");
            }
            return sb + element.toString();
        }
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;

        // 添加根节点的情况, 根据红黑树的定义只需要将根节点染成黑色
        if (parent == null){
            black(node);
            return;
        }

        // 父节点为黑色不需要特殊处理
        if (isBlack(parent)) {
            return;
        }

        Node<E> uncle = node.uncle();
        Node<E> grand = parent.parent;
        // 叔父节点为红色情况为上溢情况
        if (isRed(uncle)){
            black(parent);
            black(uncle);
            // 祖父节点上溢, 当成是新添加的节点, 由于是当成新添加的节点, 再次调用afterAdd即可
            afterAdd(red(grand));
            return;
        }

        // 叔父节点不是红色
        if (parent.isLeftChild()){
            // LL
            if (node.isLeftChild()){
                black(parent);
                red(grand);
                rotateRight(grand);
            }else { //LR
                black(node);
                red(grand);
                rotateLeft(parent);
                rotateRight(grand);
            }
        }else {
            // RL
            if (node.isLeftChild()){
                black(node);
                red(grand);
                rotateRight(parent);
                rotateLeft(grand);
            }else { //RR
                black(parent);
                red(grand);
                rotateLeft(grand);
            }
        }

    }

    @Override
    protected void afterRemove(Node<E> node) {
        super.afterRemove(node);
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RbNode<>(element, parent);
    }

    /**
     * 改变节点的颜色
     * @param node 待改变颜色的节点
     * @param color 改变后的颜色
     * @return 改变颜色后的节点
     */
    private Node<E> color(Node<E> node, boolean color){
        if (node == null){
            return null;
        }
        ((RbNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node){
        return color(node, RED);
    }

    private Node<E> black(Node<E> node){
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node){
        return node == null ? BLACK : ((RbNode<E>)node).color;
    }

    private boolean isBlack(Node<E> node){
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node){
        return colorOf(node) == RED;
    }
}
