package qr.data.structure.tree;

import org.junit.Test;
import qr.data.structure.tree.printer.BinaryTrees;

/**
 * @Author: QR
 * @Date: 2021/7/13-14:55
 */
public class AVLTests {

    private final static AvlTree<Integer> nums_Avl = new AvlTree<>();
    private final static Integer[] nums = new Integer[] {
            85, 19, 69, 3, 7, 99, 95, 2, 1, 77, 51, 58, 11, 21, 15, 93, 57, 22, 2, 66
    };

    static {
        for (Integer num : nums) {
            nums_Avl.add(num);
        }
    }

    @Test
    public void AvlTest() {
        BinaryTrees.println(nums_Avl);
    }

    @Test
    public void AvlVSBst(){
        Integer[] nums = new Integer[]{1,2,3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        AvlTree<Integer> avl = new AvlTree<>();
        for (Integer num : nums) {
            bst.add(num);
            avl.add(num);
        }
        BinaryTrees.println(bst);
        BinaryTrees.println(avl);
    }

    @Test
    public void removeTest(){
        Integer[] nums = new Integer[]{85, 19, 69, 3, 7, 99, 95};
        AvlTree<Integer> avl = new AvlTree<>();
        for (Integer num : nums) {
            avl.add(num);
        }
        BinaryTrees.println(avl);
        avl.remove(95);
        avl.remove(95);
        avl.remove(99);
        BinaryTrees.println(avl);
    }
}
