package qr.data.structure.heap;

/**
 * @Author: QR
 * @Date: 2021/7/25-12:46
 */
@SuppressWarnings("all")
public interface Heap<E> {

    /**
     * 返回堆的元素个数
     * @return 堆元素个数
     */
    int size();

    /**
     * 判断堆是否为空
     * @return 堆是否为空的结果
     */
    boolean isEmpty();

    /**
     * 清空堆
     */
    void clear();

    /**
     * 添加一个元素
     * @param element 待添加的元素
     */
    void add(E element);

    /**
     * 获取堆顶元素
     * @return 堆顶元素
     */
    E get();

    /**
     * 删除堆顶元素
     * @return 被删除的元素
     */
    E remove();

    /**
     * 删除堆顶元素的同时插入一个元素
     * @param element 插入一个元素
     * @return 被删除的元素
     */
    E replace(E element);
}
