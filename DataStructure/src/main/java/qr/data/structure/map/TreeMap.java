package qr.data.structure.map;

/**
 * @Author: QR
 * @Date: 2021/7/19-19:24
 */
@SuppressWarnings("unused")
public class TreeMap<K, V> implements Map<K, V>{

    private static final boolean RED = false;
    private static final boolean BLACK = true;

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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(K value) {
        return false;
    }

    @Override
    public void traversal(Visitor<K, V> visitor) {

    }
}
