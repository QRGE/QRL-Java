package qr.Java.dataStructure.Tree;

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
            int rightHeight = left == null ? 0 : ((AvlNode<E>)right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>)left).height;
            int rightHeight = left == null ? 0 : ((AvlNode<E>)right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AvlNode<E>)left).height;
            int rightHeight = left == null ? 0 : ((AvlNode<E>)right).height;
            if (leftHeight > rightHeight) {
                return left;
            }
            if (leftHeight < rightHeight) {
                return right;
            }
            return ifLeftChild() ? left : right;

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
    }


}
