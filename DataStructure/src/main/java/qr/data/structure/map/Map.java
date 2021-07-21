package qr.data.structure.map;

/**
 * @Author: QR
 * @Date: 2021/7/19-19:16
 */
@SuppressWarnings("unused")
public interface Map<K, V> {

    /**
     * 包含键值对的个数
     * @return 键值对格式
     */
    int size();

    /**
     * 查询 Map 是否为空
     * @return Map 是否为空结果
     */
    boolean isEmpty();

    /**
     * 清空Map
     */
    void clear();

    /**
     * 添加键值对 K : V
     * @param key 添加的键
     * @param value 如果Map中 K : V1 已经存在, 则返回原来的 V1, 否则返回null
     * @return 添加的值
     */
    V put(K key, V value);

    /**
     * 通过对应 Key 获取对应的 value
     * @param key 待查询 Value 的 Key
     * @return 返回查询得到的 Key
     */
    V get(K key);

    /**
     * 通过 key 删除对应的键值对
     * @param key 待删除键值对
     * @return 被删除键值对的 Value
     */
    V remove(K key);

    /**
     * 查询Map中是否包含指定的Key
     * @param key 指定的Key
     * @return 查询结果
     */
    boolean containsKey(K key);

    /**
     * 查询Map中是否包含指定的Value
     * @param value 指定的Value
     * @return 查询结果
     */
    boolean containsValue(K value);

    /**
     * 遍历Map
     * @param visitor 用于设置遍历时使用的方法
     */
    void traversal(Visitor<K, V> visitor);

    abstract class Visitor<K, V> {
        boolean stop = true;

        /**
         * 遍历Map中的键值对时操作
         * @param key 遍历中元素的 key
         * @param value 遍历中元素的 value
         * @return 返回一个布尔值, 可以用于判断是否继续执行遍历
         */
        abstract boolean visit(K key, V value);
    }
}
