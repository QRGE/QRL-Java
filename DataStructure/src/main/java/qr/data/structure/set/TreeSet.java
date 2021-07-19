package qr.data.structure.set;

import qr.data.structure.tree.BinaryTree;
import qr.data.structure.tree.RedBlackTree;

/**
 * @Author: QR
 * @Date: 2021/7/19-15:10
 */
@SuppressWarnings("unused")
public class TreeSet<E> implements Set<E>{

    private RedBlackTree<E> tree = new RedBlackTree<>();

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void clear() {
        tree.clear();
    }

    @Override
    public boolean contains(E element) {
        return tree.contains(element);
    }

    @Override
    public void add(E element) {
        tree.add(element);
    }

    @Override
    public void remove(E element) {
        tree.remove(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        tree.inorderTraversal(new BinaryTree.Visitor<E>() {
            @Override
            protected boolean visit(E element) {
                return visitor.visit(element);
            }
        });
    }
}
