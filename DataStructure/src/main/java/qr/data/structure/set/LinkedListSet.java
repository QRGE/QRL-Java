package qr.data.structure.set;


import java.util.List;
import java.util.LinkedList;

/**
 * 利用链表实现集合
 * @Author: QR
 * @Date: 2021/7/19-13:28
 */
@SuppressWarnings("unused")
public class LinkedListSet<E> implements Set<E> {

    private final List<E> list = new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    @Override
    public void add(E element) {
        // 如果 Set 中含有 element 则将传入值进行替换后返回
        if (list.contains(element)){
            int index = list.indexOf(element);
            if (index >= 0) {
                list.set(index, element);
            }else {
                list.add(element);
            }
        }
        list.add(element);
    }

    @Override
    public void remove(E element) {
        int index = list.indexOf(element);
        if (index >=0){
            list.remove(index);
        }
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        if (visitor == null){
            return;
        }
        int size = list.size();
        for (E e : list) {
            boolean result = visitor.visit(e);
            if (result) {
                break;
            }
        }
    }
}
