package qr.data.structure.map;

/**
 * @Author: QR
 * @Date: 2021/7/24-15:44
 */
@SuppressWarnings("all")
public class LinkedHashMap<K, V> extends HashMap<K, V>{

    private LinkedNode<K, V> first;
    private LinkedNode<K, V> last;

    private static class LinkedNode<K, V> extends HashMap.Node<K, V>{

        LinkedNode<K, V> prev;
        LinkedNode<K, V> next;

        public LinkedNode(K key, V value, Node<K, V> parent) {
            super(key, value, parent);
        }
    }

    @Override
    protected Node<K, V> createNode(K key, V value, Node<K, V> parent) {
        LinkedNode<K, V> node = new LinkedNode<>(key, value, parent);
        if (first == null){
            first = last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        return node;
    }

    @Override
    public void clear() {
        super.clear();
        last = null;
        first = null;
    }

    /**
     * 按照添加元素的顺序遍历元素
     * @param visitor visitor
     */
    @Override
    public void traversal(Visitor<K, V> visitor) {
        if (visitor == null) {
            return;
        }
        LinkedNode<K, V> node = first;
        while (node!= null){
            boolean result = visitor.visit(node.key, node.value);
            if (!result) {
                return;
            }
            node = node.next;
        }
    }

    @Override
    protected V remove(Node<K, V> node) {
        if (node == null) {
            return null;
        }

        return super.remove(node);
    }

    @Override
    protected void afterRmove(Node<K, V> removeNode, Node<K, V> willNode) {
        LinkedNode<K, V> node1 = (LinkedNode<K, V>) removeNode;
        LinkedNode<K, V> node2 = (LinkedNode<K, V>) willNode;
        if (node1 != node2){
            // 交换 linkedWillNode 和 node1 在链表中的位置
            // 交换prev
            LinkedNode<K, V> temp = node1.prev;
            node1.prev = node2.prev;
            node2.prev = temp;
            if (node1.prev == null) {
                first = node1;
            }else {
                node1.prev.next = node1;
            }
            if (node2.prev == null) {
                first = node2;
            }else {
                node2.prev.next = node2;
            }
            // 交换next
            LinkedNode<K, V> temp2 = node1.next;
            node1.next = node2.next;
            node2.next = temp2;
            if (node1.next == null){
                last = node1;
            }else {
                node1.next.prev = node1;
            }
            if (node2.next == null){
                last = node2;
            }else {
                node2.next.prev = node2;
            }
        }
        LinkedNode<K, V> prevNode = ((LinkedNode<K, V>) removeNode).prev;
        LinkedNode<K, V> nextNode = ((LinkedNode<K, V>) removeNode).next;
        if (prevNode == null){
            first = nextNode;
        }else {
            prevNode.next =nextNode;
        }
        if (nextNode == null){
            last = prevNode;
        }else {
            nextNode.prev = prevNode;
        }
    }
}
