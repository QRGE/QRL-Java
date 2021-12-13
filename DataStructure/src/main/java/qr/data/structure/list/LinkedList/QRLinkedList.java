package qr.data.structure.list.LinkedList;

import java.util.LinkedList;

/**
 * 我不喜欢看到 !
 * @author qr
 * @date 2021/12/13 23:44
 */
public class QRLinkedList<T> extends LinkedList<T> {

    public boolean isNotEmpty() {
        return !isEmpty();
    }
}
