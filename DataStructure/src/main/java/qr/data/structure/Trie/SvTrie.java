package qr.data.structure.Trie;

import java.util.HashMap;

/**
 * Str : Value 的 trie
 * @Author: QR
 * @Date: 2021/7/26-15:44
 */
@SuppressWarnings("all")
public class SvTrie<V> implements Trie<V>{

    private int size;
    private Node<V> root;

    private static class Node<V>{

        Node<V> parent;

        /**
         * 利用 hashMap 存储子节点的字符
         */
        HashMap<Character, Node<V>> children;

        Character character;

        V value;

        /**
         * 判断是否为单词的结尾
         */
        boolean wordEnd;

        public Node(Node<V> parent) {
            this.parent = parent;
        }
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
        size = 0;
        root = null;
    }

    @Override
    public boolean contains(String str) {
        Node<V> node = node(str);
        return node != null && node.wordEnd;
    }

    @Override
    public V get(String key) {
        Node<V> node = node(key);
        return node != null && node.wordEnd ? node.value : null;
    }

    @Override
    public V add(String str, V value) {
        keyCheck(str);

        if (root == null) {
            root = new Node<>(null);
        }

        Node<V> node = root;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            boolean emptyChildren = node.children == null;
            Node<V> childNode = emptyChildren ? null : node.children.get(c);
            if (childNode == null) {
                childNode = new Node<>(node);
                childNode.character = c;
                node.children = emptyChildren ? new HashMap<Character, Node<V>>() : node.children;
                childNode.children.put(c, childNode);
            }
            node = childNode;
        }
        // 退出循环, 对新建的 或 已经存在的节点(原来不是单词的结尾) 设置为 wordEnd， 并赋值 value
        if (!node.wordEnd) {
            node.wordEnd = true;
            node.value = value;
            size++;
            return null;
        }
        // Tire 中有 str 单词, 将 str 的 value 覆盖并返回原来的 value
        V oldValue = node.value;
        node.value = value;
        return oldValue;
    }

    @Override
    public V remove(String str) {
        Node<V> node = node(str);
        // 找不到对应的 node 或者 不是一个单词 则不需要进行处理
        if (node == null || !node.wordEnd) {
            return null;
        }
        V oldValue = node.value;
        // 还有子节点的情况则只需要将此节点设置为非单词结尾的节点即可
        if (node.children != null && !node.children.isEmpty()) {
            node.wordEnd = false;
            node.value = null;
            return oldValue;
        }
        // 没有子节点的情况
        Node<V> parent = null;
        while ((parent = node.parent) != null){
            parent.children.remove(node.character);
            if (parent.wordEnd || !parent.children.isEmpty()) {
                break;
            }
            node = parent;
        }
        size--;
        return oldValue;
    }

    @Override
    public boolean startsWith(String prefix) {
        return node(prefix) != null;
    }

    private Node<V> node(String key){
        keyCheck(key);

        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            if (node == null || node.children == null || node.children.isEmpty()) {
                return null;
            }
            char c = key.charAt(i);
            node = node.children.get(c);

        }
        // 遍历完没有提交返回说明包含 key 中的所有字符, 但是需要判断是否有这个单词?
        return node.wordEnd ? node : null;
    }

    private void keyCheck(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("Key must not be null");
        }
    }
}
