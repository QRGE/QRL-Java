package qr.data.structure.tree;

import qr.data.structure.tree.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: QR
 * @Date: 2021/7/9-14:49
 */
@SuppressWarnings("unchecked")
public class BinaryTree<E> implements BinaryTreeInfo {

    protected int size;

    protected Node<E> root;

    /**
     * 前序遍历: 根 -> 左 -> 右
     * @param visitor 遍历时节点触发的函数
     */
    public void preorderTraversal(Visitor<E> visitor) {
        if (visitor == null){
            return;
        }
        preorderTraversal(root, visitor);
    }

    private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || !visitor.result){
            return;
        }
        visitor.result = visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.left, visitor);
    }

    /**
     * 中序遍历 左 -> 根 -> 右
     * @param visitor 遍历时节点触发的函数
     */
    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || !visitor.result) {
            return;
        }
        inorderTraversal(node.left, visitor);
        if (!visitor.result){
            return;
        }
        visitor.result = visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    /**
     * 后续遍历 左 -> 右 -> 根
     * @param visitor 遍历时节点触发的函数
     */
    public void postorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        postorderTraversal(root, visitor);
    }

    private void postorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || !visitor.result){
            return;
        }
        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        if (!visitor.result) {
            return;
        }
        visitor.visit(node.element);
    }

    /**
     * 层序遍历
     * @param visitor 遍历时节点触发的函数
     */
    public void levelOrderTraversal(Visitor<E> visitor) {
        if (visitor == null){
            return;
        }
        levelOrderTraversal(root, visitor);
    }

    private void levelOrderTraversal(Node<E> root, Visitor<E> visitor) {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if (!visitor.visit(node.element)) {
                return;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    /**
     * 节点类, 作为BST的节点保存数据
     * @param <E> 节点保存数据的类型
     */
    protected static class Node<E> {
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

        /**
         * 判断自己是否为父节点的左子树
         * @return 判断结果
         */
        public boolean isLeftChild(){
            return parent != null && parent.left == this;
        }

        /**
         * 判断自己是否为父节点的右子节点
         * @return 判断结果
         */
        public boolean isRightChild(){
            return parent != null && parent.right == this;
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
    protected Node<E> predecessor(Node<E> node) {
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
    protected Node<E> successor(Node<E> node) {
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
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

    protected Node<E> createNode(E element, Node<E> parent){
        return new Node<>(element, parent);
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
