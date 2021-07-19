package qr.data.structure.set;

/**
 * @Author: QR
 * @Date: 2021/7/19-13:23
 */
public interface Set<E> {

    int size();

    boolean isEmpty();

    void clear();

    boolean contains(E element);

    void add(E element);

    void remove(E element);

    void traversal(Visitor<E> visitor);

    abstract class Visitor<E> {
        boolean stop;
        abstract boolean visit(E element);
    }
}
