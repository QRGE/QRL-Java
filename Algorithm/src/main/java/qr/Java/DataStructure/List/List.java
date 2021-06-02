package qr.Java.DataStructure.List;

public interface List<E> {

    int ELEMENT_NOT_FOUND = -1; // 接口成员变量都默认为 public final static, 可访问的常量可以放在接口里

    boolean isEmpty(); // 查看数组是否为空

    boolean contain(E element); // 查看是否包含某个元素

    E get(int index); // 通过索引值获取某个元素

    // 通过索引值设置某个索引值位置的元素,如果原来的位置已经有元素则进行覆盖
    E set(int index, E element);

    void add(E element); // 添加一个元素

    void add(int index, E element); // 在指定的索引处添加一个元素

    E remove(int index); // 通过索引值删除一个元素

    void remove(E element); // 删除一个指定的元素

    int indexOf(E element); // 删除某个元素

    void clear(); // 清空所有元素

    int size();
}
