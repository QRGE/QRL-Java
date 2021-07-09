package qr.Java.dataStructure.List;

public abstract class AbstractList<E> implements List<E>{

    protected int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean contain(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    // 在先线性表的末尾处添加一个元素
    public void add(E element) {
        add(size, element);
    }

    // 查看索引是否超出范围
    protected void rangeCheck(int index){
        if (index < 0 || index >= size) {
            outOfBound(index);
        }
    }


    // 针对于add方法的查看索引的方法
    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBound(index);
        }
    }

    protected void outOfBound(int index){
        throw new ArrayIndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }
}
