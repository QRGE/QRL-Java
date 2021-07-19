package qr.data.structure.list;

/**
 * @author QR
 */
public interface List<E> {

    int ELEMENT_NOT_FOUND = -1;

    /**
     * 判断数组是否为空
     * @return 判断结果
     */
    boolean isEmpty();

    /**
     * 查询是否包含某个指定的元素
     * @param element 指定元素
     * @return 查询结果
     */
    boolean contain(E element);

    /**
     * 通过索引值获取某个元素
     * @param index 索引值
     * @return 获取元素
     */
    E get(int index);

    /**
     * 通过索引值设置某个索引值位置的元素,如果原来的位置已经有元素则进行覆盖
     * @param index 索引值
     * @param element 元素
     * @return 倍替换的元素
     */
    E set(int index, E element);

    /**
     * 添加一个元素
     * @param element 添加的元素
     */
    void add(E element);

    /**
     * 在指定的索引处添加一个元素
     * @param index 指定索引
     * @param element 添加的元素
     */
    void add(int index, E element);

    /**
     * 通过索引值删除一个元素
     * @param index 删除元素的索引值
     * @return 被删除的元素
     */
    E remove(int index); //

    /**
     * 删除一个指定的元素
     * @param element 指定的元素值
     */
    void remove(E element);

    /**
     * 获取某个元素的索引值
     * @param element 待获取索引值的元素
     * @return 索引值
     */
    int indexOf(E element);

    /**
     * 清空所有元素
     */
    void clear();

    /**
     * 获取线性表中的元素个数
     * @return 元素个数
     */
    int size();
}
