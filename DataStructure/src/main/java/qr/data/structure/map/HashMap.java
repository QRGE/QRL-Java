package qr.data.structure.map;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Comparale 和 equals 的重写
 * @Author: QR
 * @Date: 2021/7/21-18:36
 */

@SuppressWarnings("all")
public class HashMap<K, V> implements Map<K, V>{

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    /**
     * 默认容量为16
     */
    private static final int DEFAULT_CAPACITY = 1 << 4;
    /**
     * 装填因子: 总结点个数 / 桶的长度
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    protected static class Node<K, V>{
        int keyHash;
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
            this.keyHash = key == null ? 0 : key.hashCode();
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

    private int size;
    private Node<K, V>[] table;

    public HashMap(){
        table = new Node[DEFAULT_CAPACITY];
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
        if (size == 0){
            return;
        }
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        resize();
        int index = index(key);
        Node<K, V> root = table[index];
        if (root == null){
            root = createNode(key, value, null);
            table[index] = root;
            size++;
            fixAfterPut(root);
            return null;
        }
        // 哈希冲突情况
        // 如果找到相同的key则替换值
        Node<K, V> node = root;
        Node<K, V> parent = null;
        // compareResult
        int cpr = 0;
        K k1 = key;
        int h1 = k1 == null ? 0 : k1.hashCode();
        Node<K, V> result = null;
        // 标记是否已经进行搜索
        boolean searched = false;
        do  {
            // 保存父节点
            parent = node;
            int h2 = node.keyHash;
            K k2 =  node.key;
            if (h1 > h2){
                cpr = 1;
            }else if (h1 < h2){
                cpr = -1;
            }else if (Objects.equals(k1, k2)){
                cpr = 0;
            }else if (k1!=null && k2!= null && k1.getClass() == k2.getClass() &&
                      k1 instanceof Comparable &&
                      (cpr = ((Comparable<K>) k1).compareTo(k2)) != 0){
                // equal 和 compareTo 的逻辑冲突
            }else if (!searched){ // 先扫描查看是否有重复节点, 搜索过无重复节点后不需要再次搜索
                if ((node.left != null && (result = node(node.left, k1)) != null) ||
                    (node.right != null && (result = node(node.right, k1)) != null)){
                    node = result;
                    cpr = 0;
                }else { // 最后在根据内存地址决定大小
                    searched = true;
                    cpr = System.identityHashCode(k1) - System.identityHashCode(k2);
                }
            }else { // 搜索过没有重复节点后直接进行内存地址比较
                cpr = System.identityHashCode(k1) - System.identityHashCode(k2);
            }
            if (cpr > 0){
                node = node.right;
            } else if (cpr < 0){
                node = node.left;
            } else { // 覆盖原来的Node
                node.key = key;
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        } while ((node != null));
        // 如果没找到相同key则进行添加
        Node<K, V> addNode = createNode(k1, value, parent);
        if (cpr > 0){
            parent.right = addNode;
        } else {
            parent.left = addNode;
        }
        size++;
        fixAfterPut(addNode);
        return null;
    }

    private void resize() {
        if (size / table.length <= DEFAULT_LOAD_FACTOR) {
            return;
        }
        Node<K, V>[] oldTable = table;
        // 默认扩容1倍
        table = new Node[oldTable.length << 1];
        Queue<Node<K, V>> queue = new LinkedList<>();
        for (int i = 0; i < oldTable.length; i++) {
            queue.offer(oldTable[i]);
            while (!queue.isEmpty()){
                Node<K, V> node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                moveNode(node);
            }
        }
    }

    private void moveNode(Node<K,V> newNode) {
        // 清空node的parent, left, right 并且新节点都为红色
        newNode.parent = null; newNode.left = null; newNode.right = null; newNode.color = RED;
        // 此时 table.length 已经改变
        int index = index(newNode.key);
        Node<K, V> root = table[index];
        if (root == null){
            root = newNode;
            table[index] = root;
            fixAfterPut(root);
            return;
        }
        // 哈希冲突情况
        // 如果找到相同的key则替换值
        Node<K, V> node = root;
        Node<K, V> parent = null;
        // compareResult
        int cpr = 0;
        K k1 = newNode.key;
        int h1 = newNode.keyHash;
        Node<K, V> result = null;
        do  {
            // 保存父节点
            parent = node;
            int h2 = node.keyHash;
            K k2 =  node.key;
            if (h1 > h2){
                cpr = 1;
            }else if (h1 < h2){
                cpr = -1;
            }else if (k1!=null && k2!= null && k1.getClass() == k2.getClass() &&
                    k1 instanceof Comparable &&
                    (cpr = ((Comparable<K>) k1).compareTo(k2)) != 0){
            }else { // 不需要进行搜索查看是否有重复的key
                cpr = System.identityHashCode(k1) - System.identityHashCode(k2);
            }
            if (cpr > 0){
                node = node.right;
            } else if (cpr < 0){
                node = node.left;
            }
        } while ((node != null));

        if (cpr > 0){
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        newNode.parent = parent;
        fixAfterPut(newNode);
    }

    @Override
    public V get(K key) {
        Node<K, V> node = node(key);
        return node == null ? null : node.value;
    }

    private Node<K, V> node(K key){
        Node<K, V> root = table[index(key)];
        return root == null ? null : node(root, key);
    }

    private Node<K, V> node(Node<K, V> node, K k1){
        int h1 = k1 == null ? 0 : k1.hashCode();
        int cpr = 0;
        // 保存查找结果
        Node<K, V> result = null;
        while (node != null){
            int h2 = node.keyHash;
            K k2 = node.key;
            if (h1 > h2){
                node = node.right;
            } else if (h1 < h2){
                node = node.left;
            } else if (Objects.equals(k1, k2)){
                return node;
            } else if ( // hashCode相等且 k1 和 k2 为同种类型并具备可比较性
                    k1 != null && k2 != null && k1.getClass() == k2.getClass() &&
                    k1 instanceof Comparable &&
                    (cpr = ((Comparable<K>) k1).compareTo(k2)) != 0){
                // 比较只是决定大小, 不能通过 cpr=0 决定两个对象是否相等
                node = cpr > 0 ? node.right : node.left;
            }
            // hashCode 相等但是不具备可比较性
            else if (node.right != null && (result = node(node.right, k1)) != null){
                return result;
            }else { // 如果右边没找到相同的子节点, 就往左边找, 只需要递归判断以便即可
                node = node.left;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        return remove(node(key));
    }

    protected V remove(Node<K,V> node) {
        if (node == null) {
            return null;
        }
        Node<K, V> willNode = node;
        V oldValue = node.value;
        // 删除度为2的节点: 找到节点的前驱或后继节点替换原来的位置
        if (node.hasTwoChildNode()){
            Node<K, V> sNode = successor(node);
            node.key = sNode.key;
            node.value = sNode.value;
            // 哈希值也需要覆盖
            node.keyHash = sNode.keyHash;
            // 将Node引用sNode对象, 后面只需要删除Node即可
            node = sNode;
        }
        // 删除度为1或0的节点的情况
        Node<K, V> replaceNode = node.left != null ? node.left : node.right;
        int index = index(node);
        // 度为1的节点则删除自己(父节点指向自己的子节点)
        if (replaceNode != null) {
            // 设置替换节点的父节点
            replaceNode.parent = node.parent;
            // 根节点的情况
            if (node.parent == null) {
                table[index] = replaceNode;
            }else if (node == node.parent.left) {
                node.parent.left = replaceNode;
            }else if (node == node.parent.right) {
                node.parent.right = replaceNode;
            }
            // 删除节点后的处理, 可以用于恢复平衡
            fixAfterRemove(replaceNode);
        }
        // 叶子节点&&根节点
        else if (node.parent == null) {
            table[index] = null;
            fixAfterRemove(node);
        }
        // 叶子节点且非根节点
        else {
            if (node == node.parent.left){
                node.parent.left = null;
            }
            if (node == node.parent.right) {
                node.parent.right = null;
            }
            fixAfterRemove(node);
        }
        // 可用于处理LinkedHashMap的顺序问题
        afterRmove(node, willNode);
        size--;
        return oldValue;
    }

    private void fixAfterRemove(Node<K, V> node) {
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
                    fixAfterRemove(parent);
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
                    fixAfterRemove(parent);
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

    /**
     * 查询 hashMap 中是否包含指定的 value
     * 用于 value 并没有可比较性也不能通过 value 获取对应的 index, 只能遍历 table 中的所有红黑树节点
     * @param value 指定的Value
     * @return 查询结果
     */
    @Override
    public boolean containsValue(K value) {
        if (size == 0) {
            return false;
        }
        Queue<Node<K, V>> queue = new LinkedList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            queue.offer(table[i]);
            Node<K, V> node;
            while (!queue.isEmpty()){
                node = queue.poll();
                if (Objects.equals(node.value, value)){
                    return true;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return false;
    }

    @Override
    public void traversal(Visitor<K, V> visitor) {
        if (size == 0 || visitor == null) {
            return;
        }
        Queue<Node<K, V>> queue = new LinkedList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            queue.offer(table[i]);
            Node<K, V> node;
            while (!queue.isEmpty()){
                node = queue.poll();
                // 执行 visitor 设置的 visit 函数
                boolean result = visitor.visit(node.key, node.value);
                if (!result){
                    return;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
    }

    /**
     * 获取 key 存放在 table 中的索引
     * @param key 查询索引得key
     * @return 查询到的索引
     */
    private int index(K key){
        // 默认空的key在数组0位置
        if (key == null){
            return 0;
        }
        int hashCode = key.hashCode();
        /// hashCode ^ (hashCode >>> 16): 将获得的hashCode()的高低16位异或后得出 hashCode
        return (hashCode ^ (hashCode >>> 16)) & (table.length - 1);
    }

    private int index(Node<K, V> node){
        return (node.keyHash ^ (node.keyHash >>> 16)) & (table.length) - 1;
    }

    private void fixAfterPut(Node<K,V> node) {
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
            fixAfterPut(red(grand));
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
        }else { // 即旋转后parent成为根节点的情况, 只需要找到grand, parent或child所在的红黑树即可
            table[index(grand.key)] = parent;
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
     * 设置两个 key 的比较规则, 由于 Map 传入的 key 并不要求含有比较性, 所以比较麻烦
     * 首先通过 k1 和 k2 的哈希值进行比较, 如果如果哈希值不相等则返回比较结果
     * 如果哈希值相等, 比较 k1 和 k2 是否为同一个对象, 如果是同一个对象则直接返回
     * 不为同一个对象则比较他们的类, 通过类名进行比较, 如果类名不同则返回类名的比较结果
     * 如果类名相同则查看 k1 是具有比较性, 如果有则将 k1 和 k2 进行比较
     * 如果类名相同又不具备比较性, 则将 k1 和 k2 的 identityHashCode 进行比较
     * @param k1 k1
     * @param k2 k2
     * @param kh1 k1的hashCode
     * @param kh2 k2的hashCode
     * @return 比较结果
     */
    private int compare(K k1, K k2, int kh1, int kh2){
        int result = kh1 - kh2;
        if (result != 0){
            return result;
        }
        // key相等
        if (Objects.equals(k1, k2)){
            return 0;
        }
        // k1 和 k2 具备可比较性且为同种类型, 并实现了 Comparable
        if (k1 != null && k2!=null
                && k1.getClass() == k2.getClass()
                && k1 instanceof Comparable){
            return ((Comparable<K>) k1).compareTo(k2);
        }
        // 同种类型但不具备比较性, 通过内存地址得出的哈希值进行比较
        return System.identityHashCode(k1) - System.identityHashCode(k2);
    }

    /**
     * predecessor: 前驱节点, 中序遍历中某个节点的前一个节点即为前驱节点
     * 针对BST, 某个节点的前驱节点如果存在, 必然是其左子树的最大值的节点
     * @param node 待求前驱节点的节点
     * @return 求得的前驱节点
     */
    private Node<K, V> predecessor(Node<K, V> node) {
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
    private Node<K, V> successor(Node<K, V> node) {
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

    protected Node<K, V> createNode(K key, V value, Node<K, V> parent){
        return new Node<>(key, value, parent);
    }

    protected void afterRmove(Node<K, V> removeNode, Node<K, V> willNode) {

    }
}
