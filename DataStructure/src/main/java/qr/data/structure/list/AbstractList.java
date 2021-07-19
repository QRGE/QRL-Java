package qr.data.structure.list;

/**
 * @author QR
 */
public abstract class AbstractList<E> implements List<E>{

    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contain(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * 查看索引是否超出范围
     * @param index 待检测的索引值
     */
    protected void rangeCheck(int index){
        if (index < 0 || index >= size) {
            outOfBound(index);
        }
    }

    /**
     * 针对于add方法的查看索引的方法
     * @param index 待检测的索引值
     */
    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBound(index);
        }
    }

    protected void outOfBound(int index){
        throw new ArrayIndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }
}
