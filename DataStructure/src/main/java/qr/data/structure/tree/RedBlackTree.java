package qr.data.structure.tree;

import java.util.Comparator;

/**
 * @Author: QR
 * @Date: 2021/7/16-15:42
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
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
            red(grand);
            if (node.isLeftChild()){
                black(parent);
            }else { //LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);
        }else {
            // RL
            red(grand);
            if (node.isLeftChild()){
                black(node);
                rotateRight(parent);
            }else { //RR
                black(parent);
            }
            rotateLeft(grand);
        }

    }

    /**
     * 删除节点之后的操作, 被删除的节点总发生在叶子节点中
     * @param node 删除的节点
     */
    @Override
    protected void afterRemove(Node<E> node) {
        // 直接删除红色叶子节点, 直接返回不用进行特殊处理 || 删除带有红色叶子节点的黑色节点A的节点需要将A染成黑色
        if (isRed(node)){
            black(node);
            return;
        }
        Node<E> parent = node.parent;
        // 删除的是根节点(黑)
        if (parent == null){
            return;
        }
        // 删除黑色叶子节点, 等效于4阶B树即为下溢情况
        // 由于传入的node是被删除的节点, 在bst的remove中已经被删除了, 不能通过sibling()获得其兄弟节点
        boolean left = parent.left == null || node.isLeftChild();
        Node<E> sibling = left ? parent.right : parent.left;
        // 兄弟节点为黑色且至少有一个红色子节点的情况, 可以借一个节点
        // 被删除的节点在左边, 兄弟节点在右边
        if (left){
            // 兄弟节点为红色
            if (isRed(sibling)){
                black(sibling);
                red(parent);
                rotateLeft(parent);
                // 更换兄弟
                sibling = parent.right;
            }
            // 兄弟节点是黑色时:
            // 兄弟节点的子节点没有一个是红色
            if (isBlack(sibling.left) && isBlack(sibling.right)){
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack){
                    afterRemove(parent);
                }
            }else { // 兄弟节点至少有1个红色子节点, 向兄弟借元素
                // 兄弟节点右边是黑色要先进行旋转
                if (isBlack(sibling.right)){
                    rotateRight(sibling);
                    sibling = parent.right;
                }
                // 将兄弟节点先集成父节点的颜色
                color(sibling, colorOf(parent));
                black(sibling.right);
                black(parent);
                rotateLeft(parent);
            }
        }else { // 被删除的节点在右边, 兄弟节点在左边
            // 兄弟节点为红色
            if (isRed(sibling)){
                black(sibling);
                red(parent);
                rotateRight(parent);
                // 更换兄弟
                sibling = parent.left;
            }
            // 兄弟节点是黑色时:
            // 兄弟节点的子节点没有一个是红色
            if (isBlack(sibling.left) && isBlack(sibling.right)){
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack){
                    afterRemove(parent);
                }
            }else { // 兄弟节点至少有1个红色子节点, 向兄弟借元素
                // 兄弟节点左边是黑色要先进行旋转
                if (isBlack(sibling.left)){
                    rotateLeft(sibling);
                    sibling = parent.left;
                }
                // 将兄弟节点先集成父节点的颜色
                color(sibling, colorOf(parent));
                black(sibling.left);
                black(parent);
                rotateRight(parent);
            }
        }
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
