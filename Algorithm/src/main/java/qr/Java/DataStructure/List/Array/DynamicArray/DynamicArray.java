package qr.Java.DataStructure.List.Array.DynamicArray;

import qr.Java.DataStructure.List.AbstractList;

// 手写一个动态数组,理解一下ArrayList的机制
// 复杂度震荡: 如果扩容和缩容两者的时机(临界条件)相同,那么就会造成复杂度震荡, 假设你在临界条件出不断地扩容和缩容, 复杂度会一直处于O(n)

/**
 * 利用一个first存放第一个元素的索引位置,
 * 假如现在有一个arrayList长度为5, 且所有的位置都有数据, 当发生首元素删除时可以利用first指向elements的索引1, 就可以避免数组的复制操作
 */
@SuppressWarnings("unchecked")
public class DynamicArray<E> extends AbstractList<E> {

    // 用于存放所用的元素
    private E[] elements;

    private final static int DEFAULT_CAPACITY = 10;
    private final static int ELEMENT_NOT_FOUND = -1;

    public DynamicArray(int capacity){
        capacity = (capacity <= 0) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public DynamicArray(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取指定索引值的元素
     * 复杂度O(1)
     * @param index 指定的索引值
     * @return 返回指定索引值处的元素
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        // index * 数组空间大小 + 首地址
        return elements[index];
    }

    /**
     * 通过索引替换某一个元素
     * 复杂度O(1)
     * @param index 指定的索引值
     * @param element 待替换的元素
     * @return 返回被替换的元素
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 在指定的索引处添加一个元素
     * 最好时间复杂度: O(1)
     * 最坏时间复杂度: O(n)
     * 平均时间复杂度: (1 + 2 + ... + n) / n ,还是O(n)
     * @param index 指定的索引
     * @param element 待添加的元素
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        if (index != size) {
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
        elements[index] = element;
        size++;
    }

    /**
     * 通过索引进行删除元素, 删除的复杂度同add
     * @param index 待删除元素的索引
     * @return 返回被删除的元素
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);trimToSize();
        E deleted = elements[index];
        if (size - 1 - (index + 1) >= 0)
            System.arraycopy(elements, index + 1, elements, index, size - 1 - (index + 1));
        size--;
        elements[size] = null; // 同样是为了消除对象
        return deleted;
    }

    /**
     * 删除指定的第一个元素,先通过查找指定元素的索引进行判断,如果找到索引则进行删除,找不到则返回一个null
     * @param element 待删除的元素
     */
    @Override
    public void remove(E element) {
        remove(indexOf(element));
    }

    /**
     * 通过遍历elements查询一个元素在数组中<b>第一个</b>与element值相等的索引
     * @param element 待查找索引的元素
     * @return 返回一个索引值
     */
    @Override
    public int indexOf(E element) {
        // 空指针异常的处理
        if (element == null){
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // 清空数组,直接设置size=0.让get和set等操作执行不了,即访问不到原数组
    @Override
    public void clear() {
        // 清空数组里面的内存
        // 对于一个对象数组,数组中存在的值为对象的地址值,为了在clear之后尽快得消除原来的对象,需要进行设置null值
        // (这里有关Java的对象消除机制还是不很了解,但是如果数组一直保存着地址则会一直存在对原来对象的引用,对象便不会销毁)
        for (int i = 0; i < size; i++) {
            elements[i] = null;                           // 将每个元素设置成null, 断绝引用
        }
        size = 0;                                         // size设置为0
        if (elements != null && elements.length > DEFAULT_CAPACITY){
            elements = (E[])new Object[DEFAULT_CAPACITY]; // 清空数据元素后进行缩容, elements的容量恢复到默认容量
        }
    }

    private void trimToSize(){
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;
        // 当前元素个数大于容量的一半或这容量小于默认数组容量时,数组不需要扩容
        if (size >= newCapacity || oldCapacity <= DEFAULT_CAPACITY) return;
        E[] newElements = (E[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size= ").append(size).append(", { ");
        for (int i = 0; i < size; i++) {
            if(i < size - 1){
                stringBuilder.append(elements[i]).append(", ");
            }else {
                stringBuilder.append(elements[i]);
            }
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length; // 数组的容量
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public int getElementsLength(){
        return elements.length;
    }
}