package qr.data.structure.Trie;

/**
 * Trie 也叫字典树, 前缀树(Prefix Tree), 单词查找树
 * @Author: QR
 * @Date: 2021/7/26-15:34
 */
public interface Trie<V> {

    /**
     * 返回 Trie 的节点树
     * @return trie 的节点数
     */
    int size();

    /**
     * 判断 trie 是否为空
     * @return trie 是否为空
     */
    boolean isEmpty();

    /**
     * 清空 trie
     */
    void clear();

    /**
     * 查询 tire 中是否包含 str
     * @param str str
     * @return tire 中是否包含 str 的结果
     */
    boolean contains(String str);

    /**
     * 查询 Tire 中是否包含 key 并返回其 Value
     * @param key 待查询的 key
     * @return key 对应的 value
     */
    V get(String key);

    /**
     * 添加一个 str:value 到 Trie 中
     * @param str 待添加的str
     * @param value 添加的值
     * @return 返回 str 之前的 value
     */
    V add(String str, V value);

    /**
     * 删除指定的 str
     * @param str 待删除的 str
     * @return 被删除 str 的 value
     */
    V remove(String str);

    /**
     * 判断是否有单词以 prefix 开头
     * @param prefix prefix
     * @return  判断结果
     */
    boolean startsWith(String prefix);
}
