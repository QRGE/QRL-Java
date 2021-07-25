package qr.data.structure.map;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Author: QR
 * @Date: 2021/7/19-19:24
 */
@SuppressWarnings({"unused", "UnusedReturnValue", "uncheck"})
public class TreeMap<K, V> implements Map<K, V>{

    /**
     * 比较器, 用于设置红黑树节点元素的 Key 的比较规则
     */
    private final Comparator<K> comparator;

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private int size;
    private Node<K, V> root;

    private static class Node<K, V>{
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        /**
         * color默认为红色可以让红黑树的性质尽快满足
         */
        boolean color = RED;

        public Node(K key, V value, Node<K, V> parent){
            this.key = key;
            this.value = value;
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

        /**
         * 返回某个节点的兄弟节点
         * @return 兄弟节点
         */
        public Node<K, V> sibling(){
            if (isLeftChild()){
                return parent.right;
            }
            if (isRightChild()){
                return parent.left;
            }
            return null;
        }

        /**
         * 返回叔父节点, 即父节点的兄弟节点
         * @return 叔父节点
         */
        public Node<K, V> uncle(){
            return parent.sibling();
        }
    }

    public TreeMap(){
        comparator = null;
    }

    public TreeMap(Comparator<K> comparator){
        this.comparator = comparator;
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
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        keyNotNullCheck(key);
        if (root == null) {
            root = new Node<>(key, value, null);
            size++;
            afterPut(root);
            return null;
        }
        Node<K, V> node = root;
        Node<K, V> parent = null;
        int compareResult = 0;
        while (node != null) {
            compareResult = compare(key, node.key);
            parent = node;
            if (compareResult > 0){
                node = node.right;
            }else if(compareResult < 0){
                node = node.left;
            }else {
                V oldValue = node.value;
                node.key = key;
                node.value = value;
                return oldValue;
            }
        }
        Node<K, V> addNode = new Node<>(key, value, parent);
        if (compareResult > 0){
            parent.right = addNode;
        } else {
            parent.left = addNode;
        }
        size++;
        afterPut(addNode);
        return null;
    }

    private void afterPut(Node<K,V> node) {
        Node<K, V> parent = node.parent;

        // 添加根节点的情况, 根据红黑树的定义只需要将根节点染成黑色
        if (parent == null){
            black(node);
            return;
        }

        // 父节点为黑色不需要特殊处理
        if (isBlack(parent)) {
            return;
        }

        Node<K, V> uncle = node.uncle();
        Node<K, V> grand = parent.parent;
        // 叔父节点为红色情况为上溢情况
        if (isRed(uncle)){
            black(parent);
            black(uncle);
            // 祖父节点上溢, 当成是新添加的节点, 由于是当成新添加的节点, 再次调用afterAdd即可
            afterPut(red(grand));
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

    @Override
    public V get(K key) {
        Node<K, V> target = node(key);
        return target != null ? target.value : null;
    }

    @Override
    public V remove(K key) {
        // 通过 node() 找到对应 Key 的 node 再删除
        return remove(node(key));
    }

    private V remove(Node<K, V> node){
        if (node == null) {
            return null;
        }
        V oldValue = node.value;
        // 删除度为2的节点: 找到节点的前驱或后继节点替换原来的位置
        if (node.hasTwoChildNode()){
            Node<K, V> sNode = successor(node);
            node.key = sNode.key;
            node.value = sNode.value;
            // 将Node引用sNode对象, 后面只需要删除Node即可
            node = sNode;
        }
        // 删除度为1或0的节点的情况
        Node<K, V> replaceNode = node.left != null ? node.left : node.right;
        // 度为1的节点则删除自己(父节点指向自己的子节点)
        if (replaceNode != null) {
            // 设置替换节点的父节点
            replaceNode.parent = node.parent;
            // 根节点的情况
            if (node.parent == null) {
                root = replaceNode;
            }else if (node == node.parent.left) {
                node.parent.left = replaceNode;
            }else if (node == node.parent.right) {
                node.parent.right = replaceNode;
            }
            // 删除节点后的处理, 可以用于恢复平衡
            afterRemove(replaceNode);
        }
        // 叶子节点&&根节点
        else if (node.parent == null) {
            root = null;
            afterRemove(node);
        }
        // 叶子节点且非根节点
        else {
            if (node == node.parent.left){
                node.parent.left = null;
            }
            if (node == node.parent.right) {
                node.parent.right = null;
            }
            afterRemove(node);
        }
        // 减少容量
        size--;
        return oldValue;
    }

    private void afterRemove(Node<K, V> node) {
        // 直接删除红色叶子节点, 直接返回不用进行特殊处理 || 删除带有红色叶子节点的黑色节点A的节点需要将A染成黑色
        if (isRed(node)){
            black(node);
            return;
        }
        Node<K, V> parent = node.parent;
        // 删除的是根节点(黑)
        if (parent == null){
            return;
        }
        // 删除黑色叶子节点, 等效于4阶B树即为下溢情况
        // 由于传入的node是被删除的节点, 在bst的remove中已经被删除了, 不能通过sibling()获得其兄弟节点
        boolean left = parent.left == null || node.isLeftChild();
        Node<K, V> sibling = left ? parent.right : parent.left;
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
    public boolean containsKey(K key) {
        return node(key) != null;
    }

    @Override
    public boolean containsValue(K value) {
        if (root == null) {
            return false;
        }
        Queue<Node<K, V>> nodes = new LinkedList<>();
        nodes.offer(root);
        Node<K, V> node;
        while (!nodes.isEmpty()){
            node = nodes.poll();
            if (Objects.equals(node.value, value)){
                return true;
            }
            if (node.left != null){
                nodes.offer(node.left);
            }
            if (node.right != null){
                nodes.offer(node.right);
            }
        }
        // 没找到
        return false;
    }

    @Override
    public void traversal(Visitor<K, V> visitor) {
        if (visitor == null) {
            return;
        }
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(Node<K, V> node, Visitor<K, V> visitor){
        if (node == null || !visitor.stop){
            return;
        }
        inorderTraversal(node.left, visitor);
        if (!visitor.stop){
            return;
        }
        visitor.visit(node.key, node.value);
        inorderTraversal(node.right, visitor);
    }

    /**
     * 判断某个元素是否为空
     * @param key 待判断是否为空的元素
     */
    private void keyNotNullCheck(K key) {
        if (key == null){
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @SuppressWarnings("unchecked")
    private int compare(K k1, K k2){
        if (comparator != null) {
            return comparator.compare(k1, k2);
        }
        // 如果没有传入比较器, 则强制转换成Comparable类型惊醒比较, 无法比较则报错
        return ((Comparable<K>)k1).compareTo(k2);
    }

    /**
     * 改变节点的颜色
     * @param node 待改变颜色的节点
     * @param color 改变后的颜色
     * @return 改变颜色后的节点
     */
    private Node<K, V> color(Node<K, V> node, boolean color){
        if (node == null){
            return null;
        }
        node.color = color;
        return node;
    }

    private Node<K, V> red(Node<K, V> node){
        return color(node, RED);
    }

    private Node<K, V> black(Node<K, V> node){
        return color(node, BLACK);
    }

    private boolean colorOf(Node<K, V> node){
        return node == null ? BLACK : node.color;
    }

    private boolean isBlack(Node<K, V> node){
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<K, V> node){
        return colorOf(node) == RED;
    }

    private void rotateRight(Node<K, V> grand){
        Node<K, V> parent = grand.left;
        Node<K, V> child = parent.right;
        // 即使是null也可以
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);
    }

    /**
     * 右旋转
     * @param grand 待旋转的节点
     */
    private void rotateLeft(Node<K, V> grand){
        Node<K, V> parent = grand.right;
        Node<K, V> child = parent.left;
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
    private void afterRotate(Node<K, V> grand, Node<K, V> parent, Node<K, V> child) {
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

    /**
     * 通过 Key 查找指定的节点
     * @param key 指定的数据
     * @return 查找到的元素
     */
    private Node<K, V> node(K key) {
        Node<K, V> node = root;
        while (node != null) {
            int cmp = compare(key, node.key);
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
     * predecessor: 前驱节点, 中序遍历中某个节点的前一个节点即为前驱节点
     * 针对BST, 某个节点的前驱节点如果存在, 必然是其左子树的最大值的节点
     * @param node 待求前驱节点的节点
     * @return 求得的前驱节点
     */
    protected Node<K, V> predecessor(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        Node<K, V> p;
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
    protected Node<K, V> successor(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        Node<K, V> p;
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
